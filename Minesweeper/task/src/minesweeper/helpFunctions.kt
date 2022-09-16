package minesweeper

fun isDigit(string: String): Boolean {
    try {
        string.toInt()
    } catch (e: Exception) {
        return false
    }
    return true
}

fun topLeft() {
    correctFilling(1, 0)
    correctFilling(0, 1)
    correctFilling(1, 1)
}

fun topRight() {
    correctFilling(0, fieldSize - 2)
    correctFilling(1, fieldSize - 2)
    correctFilling(1, fieldSize - 1)
}

fun bottomLeft() {
    correctFilling(fieldSize - 1, 1)
    correctFilling(fieldSize - 2, 1)
    correctFilling(fieldSize - 2, 0)

}

fun bottomRight() {
    correctFilling(fieldSize - 1, fieldSize - 2)
    correctFilling(fieldSize - 2, fieldSize - 2)
    correctFilling(fieldSize - 2, fieldSize - 1)
}

fun firstRow(cell: Int) {
    correctFilling(1, cell)
    correctFilling(1, cell - 1)
    correctFilling(1, cell + 1)
    correctFilling(0, cell - 1)
    correctFilling(0, cell + 1)
}

fun lastRow(cell: Int) {
    correctFilling(fieldSize - 2, cell)
    correctFilling(fieldSize - 2, cell - 1)
    correctFilling(fieldSize - 2, cell + 1)
    correctFilling(fieldSize - 1, cell - 1)
    correctFilling(fieldSize - 1, cell + 1)
}

fun leftRow(row: Int) {
    correctFilling(row, 1)
    correctFilling(row + 1, 1)
    correctFilling(row - 1, 1)
    correctFilling(row + 1, 0)
    correctFilling(row - 1, 0)
}

fun rightRow(row: Int) {
    correctFilling(row, fieldSize - 2)
    correctFilling(row - 1, fieldSize - 2)
    correctFilling(row + 1, fieldSize - 2)
    correctFilling(row - 1, fieldSize - 1)
    correctFilling(row + 1, fieldSize - 1)
}

fun placedAnywhere(row: Int, cell: Int) {
    correctFilling(row, cell - 1)
    correctFilling(row, cell + 1)
    correctFilling(row - 1, cell - 1)
    correctFilling(row - 1, cell)
    correctFilling(row - 1, cell + 1)
    correctFilling(row + 1, cell - 1)
    correctFilling(row + 1, cell)
    correctFilling(row + 1, cell + 1)
}

fun correctFilling(row: Int, cell: Int) {
    if (isDigit(field[row][cell])) {
        field[row][cell] = (field[row][cell].toInt() + 1).toString()
    } else if (field[row][cell] == ".") {
        field[row][cell] = "1"
    }
}
