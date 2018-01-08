package it.unicam.giocoDellVita;

public class Cell {

	private boolean _state = false;
    private boolean _newState;

    public Cell() {

    }

    public Cell(boolean state) {
        this._state = state;
    }

    public void setNewState(boolean state) {
        _newState = state;
    }

    public void updateState() {
        _state = _newState;
    }

    public boolean getState() {
        return _state;
    }
}
