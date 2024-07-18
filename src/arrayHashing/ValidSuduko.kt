package arrayHashing


/**
 * validate weather a sudoku is valid
 * need to check in row there should be only 1..9  no num should repeat
 * same with column we need to check
 * then in 3x3 sub boxes we need to check only 1-9 should be there
 */
fun isValidSudoku(board: Array<CharArray>): Boolean {
        val row =Array(9){BooleanArray(9)} // row of 9x9
        val col =Array(9){BooleanArray(9)} // column of 9x9
        val box =Array(9){BooleanArray(9)} // 3x3 box of 9x9   this is sub boxes
        for(i in 0..8){
            for(j in 0..8){
                if (board[i][j]=='.')continue // if cell is empty then continue
                val num=board[i][j]-'0'-1 // get the number from cell

                if (row[i][num] || col[j][num])return false // if number is already present in row or column then return false
                row[i][num]=true // mark the number in row
                col[j][num]=true // mark the number in column

                val boxIndex=i/3*3+j/3 // get the box index
                if (box[boxIndex][num])return false // if number is already present in box then return false
                box[boxIndex][num]=true // mark the number in box
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