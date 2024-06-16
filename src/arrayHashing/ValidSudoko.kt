package arrayHashing




fun isValidSudoku(board: Array<CharArray>): Boolean {

    val rows = Array(9) { BooleanArray(9) } //total 9 rows and 9 columns
    val cols = Array(9) { BooleanArray(9) }
    val boxes = Array(9) { BooleanArray(9) } //total 9 boxes

    for (i in 0..8) {
        for (j in 0..8) {

            if (board[i][j] == '.') {
                continue;
            }

            val num =  board[i][j] - '0' - 1 //converting the char to int
            println("num at [$i][$j] : $num") //got the number at index

            if (rows[i][num]) { //if the number is already present in the row
                return false;
            }
            rows[i][num] = true;

            if (cols[j][num]) { //if the number is already present in the column
                return false;
            }
            cols[j][num] = true;


            if (boxes[(i / 3) * 3 + j / 3][num]) { //if the number is already present in the box
                return false;
            }
            boxes[(i / 3) * 3 + j / 3][num] = true;
        }
    }
    return true

}

fun main() {
    val input = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(isValidSudoku(input))

}