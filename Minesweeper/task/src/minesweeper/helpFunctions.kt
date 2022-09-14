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
    if (isDigit(field[1][0])) {
        field[1][0] = (field[1][0].toInt() + 1).toString()
    } else if (field[1][0] == ".") {
        field[1][0] = "1"
    }

    if (isDigit(field[0][1])) {
        field[0][1] = (field[0][1].toInt() + 1).toString()
    } else if (field[0][1] == ".") {
        field[0][1] = "1"
    }

    if (isDigit(field[1][1])) {
        field[1][1] = (field[1][1].toInt() + 1).toString()
    } else if (field[1][1] == ".") {
        field[1][1] = "1"
    }
}

fun topRight() {
    if (isDigit(field[0][fieldSize - 2])) {
        field[0][fieldSize - 2] = (field[0][fieldSize - 2].toInt() + 1).toString()
    } else if (field[0][fieldSize - 2] == ".") {
        field[0][fieldSize - 2] = "1"
    }

    if (isDigit(field[1][fieldSize - 2])) {
        field[1][fieldSize - 2] = (field[1][fieldSize - 2].toInt() + 1).toString()
    } else if (field[1][fieldSize - 2] == ".") {
        field[1][fieldSize - 2] = "1"
    }

    if (isDigit(field[1][fieldSize - 1])) {
        field[1][fieldSize - 1] = (field[1][fieldSize - 1].toInt() + 1).toString()
    } else if (field[1][fieldSize - 1] == ".") {
        field[1][fieldSize - 1] = "1"
    }
}

fun bottomLeft() {
    if (isDigit(field[fieldSize - 1][1])) {
        field[fieldSize - 1][1] = (field[fieldSize - 1][1].toInt() + 1).toString()
    } else if (field[fieldSize - 1][1] == ".") {
        field[fieldSize - 1][1] = "1"
    }

    if (isDigit(field[fieldSize - 2][1])) {
        field[fieldSize - 2][1] = (field[fieldSize - 2][1].toInt() + 1).toString()
    } else if (field[fieldSize - 2][1] == ".") {
        field[fieldSize - 2][1] = "1"
    }

    if (isDigit(field[fieldSize - 2][0])) {
        field[fieldSize - 2][0] = (field[fieldSize - 2][0].toInt() + 1).toString()
    } else if (field[fieldSize - 2][0] == ".") {
        field[fieldSize - 2][0] = "1"
    }
}

fun bottomRight() {
    if (isDigit(field[fieldSize - 1][fieldSize - 2])) {
        field[fieldSize - 1][fieldSize - 2] = (field[fieldSize - 1][fieldSize - 2].toInt() + 1).toString()
    } else if (field[fieldSize - 1][fieldSize - 2] == ".") {
        field[fieldSize - 1][fieldSize - 2] = "1"
    }

    if (isDigit(field[fieldSize - 2][fieldSize - 2])) {
        field[fieldSize - 2][fieldSize - 2] = (field[fieldSize - 2][fieldSize - 2].toInt() + 1).toString()
    } else if (field[fieldSize - 2][fieldSize - 2] == ".") {
        field[fieldSize - 2][fieldSize - 2] = "1"
    }

    if (isDigit(field[fieldSize - 2][fieldSize - 1])) {
        field[fieldSize - 2][fieldSize - 1] = (field[fieldSize - 2][fieldSize - 1].toInt() + 1).toString()
    } else if (field[fieldSize - 2][fieldSize - 1] == ".") {
        field[fieldSize - 2][fieldSize - 1] = "1"
    }
}

fun firstRow(cell: Int) {
    if (isDigit(field[1][cell])) {
        field[1][cell] = (field[1][cell].toInt() + 1).toString()
    } else if (field[1][cell] == ".") {
        field[1][cell] = "1"
    }

    if (isDigit(field[1][cell - 1])) {
        field[1][cell - 1] = (field[1][cell - 1].toInt() + 1).toString()
    } else if (field[1][cell - 1] == ".") {
        field[1][cell - 1] = "1"
    }

    if (isDigit(field[1][cell + 1])) {
        field[1][cell + 1] = (field[1][cell + 1].toInt() + 1).toString()
    } else if (field[1][cell + 1] == ".") {
        field[1][cell + 1] = "1"
    }

    if (isDigit(field[0][cell - 1])) {
        field[0][cell - 1] = (field[0][cell - 1].toInt() + 1).toString()
    } else if (field[0][cell - 1] == ".") {
        field[0][cell - 1] = "1"
    }

    if (isDigit(field[0][cell + 1])) {
        field[0][cell + 1] = (field[0][cell + 1].toInt() + 1).toString()
    } else if (field[0][cell + 1] == ".") {
        field[0][cell + 1] = "1"
    }
}

fun lastRow(cell: Int) {
    if (isDigit(field[fieldSize - 2][cell])) {
        field[fieldSize - 2][cell] = (field[fieldSize - 2][cell].toInt() + 1).toString()
    } else if (field[fieldSize - 2][cell] == ".") {
        field[fieldSize - 2][cell] = "1"
    }

    if (isDigit(field[fieldSize - 2][cell - 1])) {
        field[fieldSize - 2][cell - 1] = (field[fieldSize - 2][cell - 1].toInt() + 1).toString()
    } else if (field[fieldSize - 2][cell - 1] == ".") {
        field[fieldSize - 2][cell - 1] = "1"
    }

    if (isDigit(field[fieldSize - 2][cell + 1])) {
        field[fieldSize - 2][cell + 1] = (field[fieldSize - 2][cell + 1].toInt() + 1).toString()
    } else if (field[fieldSize - 2][cell + 1] == ".") {
        field[fieldSize - 2][cell + 1] = "1"
    }

    if (isDigit(field[fieldSize - 1][cell - 1])) {
        field[fieldSize - 1][cell - 1] = (field[fieldSize - 1][cell - 1].toInt() + 1).toString()
    } else if (field[fieldSize - 1][cell - 1] == ".") {
        field[fieldSize - 1][cell - 1] = "1"
    }

    if (isDigit(field[fieldSize - 1][cell + 1])) {
        field[fieldSize - 1][cell + 1] = (field[fieldSize - 1][cell + 1].toInt() + 1).toString()
    } else if (field[fieldSize - 1][cell + 1] == ".") {
        field[fieldSize - 1][cell + 1] = "1"
    }
}

fun leftRow(row: Int) {
    if (isDigit(field[row][1])) {
        field[row][1] = (field[row][1].toInt() + 1).toString()
    } else if (field[row][1] == ".") {
        field[row][1] = "1"
    }

    if (isDigit(field[row + 1][1])) {
        field[row + 1][1] = (field[row + 1][1].toInt() + 1).toString()
    } else if (field[row + 1][1] == ".") {
        field[row + 1][1] = "1"
    }

    if (isDigit(field[row - 1][1])) {
        field[row - 1][1] = (field[row - 1][1].toInt() + 1).toString()
    } else if (field[row - 1][1] == ".") {
        field[row - 1][1] = "1"
    }

    if (isDigit(field[row + 1][0])) {
        field[row + 1][0] = (field[row + 1][0].toInt() + 1).toString()
    } else if (field[row + 1][0] == ".") {
        field[row + 1][0] = "1"
    }

    if (isDigit(field[row - 1][0])) {
        field[row - 1][0] = (field[row - 1][0].toInt() + 1).toString()
    } else if (field[row - 1][0] == ".") {
        field[row - 1][0] = "1"
    }
}

fun rightRow(row: Int) {
    if (isDigit(field[row][fieldSize - 2])) {
        field[row][fieldSize - 2] = (field[row][fieldSize - 2].toInt() + 1).toString()
    } else if (field[row][fieldSize - 2] == ".") {
        field[row][fieldSize - 2] = "1"
    }

    if (isDigit(field[row - 1][fieldSize - 2])) {
        field[row - 1][fieldSize - 2] = (field[row - 1][fieldSize - 2].toInt() + 1).toString()
    } else if (field[row - 1][fieldSize - 2] == ".") {
        field[row - 1][fieldSize - 2] = "1"
    }

    if (isDigit(field[row + 1][fieldSize - 2])) {
        field[row + 1][fieldSize - 2] = (field[row + 1][fieldSize - 2].toInt() + 1).toString()
    } else if (field[row + 1][fieldSize - 2] == ".") {
        field[row + 1][fieldSize - 2] = "1"
    }

    if (isDigit(field[row - 1][fieldSize - 1])) {
        field[row - 1][fieldSize - 1] = (field[row - 1][fieldSize - 1].toInt() + 1).toString()
    } else if (field[row - 1][fieldSize - 1] == ".") {
        field[row - 1][fieldSize - 1] = "1"
    }

    if (isDigit(field[row + 1][fieldSize - 1])) {
        field[row + 1][fieldSize - 1] = (field[row + 1][fieldSize - 1].toInt() + 1).toString()
    } else if (field[row + 1][fieldSize - 1] == ".") {
        field[row + 1][fieldSize - 1] = "1"
    }
}

fun placedAnywhere(row: Int, cell: Int) {
    if (isDigit(field[row][cell - 1])) {
        field[row][cell - 1] = (field[row][cell - 1].toInt() + 1).toString()
    } else if (field[row][cell - 1] == ".") {
        field[row][cell - 1] = "1"
    }

    if (isDigit(field[row][cell + 1])) {
        field[row][cell + 1] = (field[row][cell + 1].toInt() + 1).toString()
    } else if (field[row][cell + 1] == ".") {
        field[row][cell + 1] = "1"
    }

    if (isDigit(field[row - 1][cell - 1])) {
        field[row - 1][cell - 1] = (field[row - 1][cell - 1].toInt() + 1).toString()
    } else if (field[row - 1][cell - 1] == ".") {
        field[row - 1][cell - 1] = "1"
    }

    if (isDigit(field[row - 1][cell])) {
        field[row - 1][cell] = (field[row - 1][cell].toInt() + 1).toString()
    } else if (field[row - 1][cell] == ".") {
        field[row - 1][cell] = "1"
    }

    if (isDigit(field[row - 1][cell + 1])) {
        field[row - 1][cell + 1] = (field[row - 1][cell + 1].toInt() + 1).toString()
    } else if (field[row - 1][cell + 1] == ".") {
        field[row - 1][cell + 1] = "1"
    }

    if (isDigit(field[row + 1][cell - 1])) {
        field[row + 1][cell - 1] = (field[row + 1][cell - 1].toInt() + 1).toString()
    } else if (field[row + 1][cell - 1] == ".") {
        field[row + 1][cell - 1] = "1"
    }

    if (isDigit(field[row + 1][cell])) {
        field[row + 1][cell] = (field[row + 1][cell].toInt() + 1).toString()
    } else if (field[row + 1][cell] == ".") {
        field[row + 1][cell] = "1"
    }

    if (isDigit(field[row + 1][cell + 1])) {
        field[row + 1][cell + 1] = (field[row + 1][cell + 1].toInt() + 1).toString()
    } else if (field[row + 1][cell + 1] == ".") {
        field[row + 1][cell + 1] = "1"
    }
}
