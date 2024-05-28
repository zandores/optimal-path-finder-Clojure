# optimal-path-finder-Clojure

This is a Clojure project that reads a grid from a file and finds the optimal path through the grid to maximize the collection of gold.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to have Clojure installed on your machine. You can download it from the official website: https://clojure.org/guides/getting_started

### Installing

Clone the repository to your local machine.

```bash
git clone https://github.com/zandores/optimal-path-finder-Clojure.git
```

Navigate to the project directory.

```bash
cd optimal-path-finder-Clojure
```

### Usage

The main function takes a filename as an argument. The file should contain a grid of integers representing the amount of gold at each location.

```bash
clj -M src/user.clj <file>
```
### Example

map.txt
```txt
(
	(5, 9, 1),
	(6, -5, -1),
	(0, 4, 1)
)
```
Terminal
```bash
clj -M src/user.clj map.txt
```

## Functionality

The project contains several functions:

- `read-map`: Reads a grid from a file.
- `generate-sequences`: Generates all possible sequences of moves (right and down) through the grid.
- `empty-map`: Creates an empty map of the same size as the grid.
- `find_optimal_path`: Finds the optimal path through the grid to maximize the collection of gold.
- `main`: Reads the grid from a file, finds the optimal path, and prints the original map, the maximum gold obtainable, the followed path, and the resulting map.

## Built With

* [Clojure](https://clojure.org/) - The programming language used.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
