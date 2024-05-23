(defn read-map [filename]
  (with-open [rdr (clojure.java.io/reader filename)]
    (read (java.io.PushbackReader. rdr))))

(defn generate-sequences [right down path]
  (if (and (= right 0) (= down 0))
    [path]
    (let [right-sequences (if (> right 0) (generate-sequences (dec right) down (conj path "Right")) [])
          down-sequences (if (> down 0) (generate-sequences right (dec down) (conj path "Down")) [])]
      (concat right-sequences down-sequences))))

(defn empty-map [grid]
  (let [rows (count grid)
        cols (count (first grid))]
    (vec (repeat rows (vec (repeat cols 0))))))

(defn find_optimal_path [grid]
  (let [rows (count grid)
        cols (count (first grid))
        max_gold (atom 0)
        path (atom [])
        map (atom [])
        sequences (generate-sequences (- rows 1) (- cols 1) [])]
    (doseq [s sequences]
      (loop [row 0
             col 0
             gold 0
             dirs s
             vmap (empty-map grid)
             ]
        (let [current_gold (nth (nth grid row) col)
              vmap (assoc-in vmap [row col] current_gold)]
          (if (empty? dirs)
            (if (> (+ gold current_gold) @max_gold)
              (do
                (reset! max_gold (+ gold current_gold))
                (reset! path s)
                (reset! map vmap))))
          (let [direction (first dirs)
                remaining (rest dirs)]
            (cond
              (= direction "Right") (recur row (inc col) (+ gold current_gold) remaining vmap)
              (= direction "Down") (recur (inc row) col (+ gold current_gold) remaining vmap)
              )))))
    {:max_gold @max_gold :path @path :map @map}
    ))

(defn -main [& args]
  (let [filename (first args)]
    (let [grid (read-map filename)]
      (println "Original map:" grid)
      (let [{:keys [max_gold path map]} (find_optimal_path grid)]
        (println "Max gold obtainable from path:" max_gold)
        (println "Followed path:" path)
        (println "Resulting map:" map)
        ))))