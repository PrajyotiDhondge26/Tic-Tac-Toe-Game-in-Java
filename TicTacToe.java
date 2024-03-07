//Tic Tac Toe
import java.util.Scanner;
class TicTacToe
{
	static String playAgain = " ";

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("------------------------Welcome to Tic Tac Toe ----------------------");
		System.out.println();
		System.out.print("Enter Player1 Name: ");
		String first = sc.nextLine();
		System.out.print("Enter Amount : Rs.");
		int amt1 = sc.nextInt();
		sc.nextLine();
		System.out.println("*** Hello "+first+" your sign is 'X' & betting amount is "+amt1+". ***");
		System.out.println();

		System.out.print("Enter Player2 Name: ");
		String second = sc.nextLine();
		System.out.print("Enter Amount : Rs.");
		int amt2 = sc.nextInt();
		int total = amt1+amt2;
		System.out.println("*** Hello "+second+" your sign is 'O' & betting amount is "+amt2+". ***");
		System.out.println();

		char board[][]= new char[3][3];
		makeBoardEmpty(board);
		char player = 'X';
		boolean gameOver = false;
		boolean draw = false;
		
		while(!gameOver)
		{
			printBoard(board);
			System.out.print("Player "+player + " enter: ");
			int row = sc.nextInt();
			int col = sc.nextInt();
			System.out.println();
			if(board[row][col]==' ')
			{
				// place the element
				board[row][col]=player;   
				gameOver = haveWon(board, player);
				if(gameOver)
				{
					if(player =='X')
					{
						System.out.println("Congratulations "+ first+" ["+player+"] you won Rs."+total);
					}
					else
					{
						System.out.println("Congratulations "+ second+" ["+player+"] you won Rs."+total);
					}
					printBoard(board);
				} 
				else
				{
					draw = gameDraw(board);
					player = (player=='X')? 'O' : 'X';
				}
			}
			else
			{
				System.out.println("Sorry "+player+" Invalid move. Try again!");

			}
			if(draw)
			{
				playAgainAgain();
			}
			if(playAgain.equals("y"))
			{
				makeBoardEmpty(board);
				playAgain = " ";
			}
			else if(!playAgain.equals("y") && !playAgain.equals(" "))
			{
				break;
			}
		}
	}
//===================================haveWon method========================================
	public static boolean haveWon(char board[][], char player)
	{
		//----> row
		for(int row = 0; row<board.length ; row++)
		{
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
			{
				return true;
			}
		}
		//---->col
		for(int col = 0; col<board[0].length; col++)
		{
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
			{
				return true;
			}
		}
		//----> diagonal
		if(board[0][0]==player && board[1][1]==player && board[2][2] ==player)
		{
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0] ==player)
		{
			return true;
		}	
		return false;
	}
//===============================Game Draw==============================================
	public static boolean gameDraw(char board[][])
	{
		//printBoard(board);
		int count = 0;
		for(int row = 0; row<board.length ; row++)
		{
			for(int col = 0 ; col<board[row].length ; col++)
			{
				if(board[row][col]!=' ')
				{
					count++;
				}
			}
		}
		if(count==9)
		{
			printBoard(board);
			return true;	
					
		}
		return false;
	}
///==============================Play Again method========================================
	public static void playAgainAgain()
	{
		Scanner sc1 = new Scanner (System.in);
		System.out.println("XXXXXXXX Game Draw. Play again  XXXXXXXX");
		System.out.println("Play again? (y/n)");
		playAgain = sc1.nextLine();
		while(!playAgain.equals("y") && !playAgain.equals("n") && !playAgain.equals(" "))
		{
			System.out.println("Please enter valid input");
			playAgain = sc1.nextLine();
			System.out.println();
		}
	}
//// ===========================Print Empty Board Method==================================
	public static void makeBoardEmpty(char board[][])
	{
		for(int row = 0; row<board.length ; row++)
		{
			for(int col = 0 ; col<board[row].length ; col++)
			{
				board[row][col]=' ';
			}
		}
	}
//==============================Print Board method=======================================
	public static void printBoard(char board[][])
	{
		for(int row = 0; row<board.length ; row++)
		{
			for(int col = 0 ; col<board[row].length ; col++)
			{
				System.out.print(board[row][col]+" | ");
			}
			System.out.println();
		}
	}
}