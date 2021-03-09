package ikab.checkers.views.console;


import ikab.checkers.models.Coordinate;
import ikab.checkers.utils.Console;

public class CoordinateView {

    public Coordinate read(String title) {
        Console console = Console.instance();
        Coordinate coordinate;
        ikab.checkers.models.Error error;
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
