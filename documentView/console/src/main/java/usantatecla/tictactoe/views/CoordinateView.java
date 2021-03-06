package usantatecla.tictactoe.views;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Error;
import usantatecla.utils.Console;

public class CoordinateView {

    public Coordinate read(String title) {
        Console console = Console.getInstance();
        Coordinate coordinate;
        Error error;
        do {
			console.writeln(title);
            int row = console.readInt("Row: ") - 1;
            int column = console.readInt("Column: ") - 1;
            coordinate = new Coordinate(row, column);
            error = coordinate.isValid();
            new ErrorView(error).writeln();
        } while (!error.isNull());
        return coordinate;
    }

}