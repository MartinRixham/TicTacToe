package tictactoe.controller;

public interface Controller
{
	String prompt();

	Result handleInput(String input);
}
