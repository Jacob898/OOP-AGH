package agh.ics.oop.model;


public class Animal implements WorldElement{
    private MapDirection direction;
    private Vector2d position;

    public Animal() {
        direction = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public Animal(MapDirection direction, Vector2d position) {
        this.direction = direction;
        this.position = position;
    }

    //getter
    public Vector2d getPosition() {
        return this.position;
    }
    //getter
    public MapDirection getDirection() {
        return this.direction;
    }

    public String toString() {
        return direction.toString();
    }

    public String toString(int numberOfAnimal){
        return "Zwierze " + numberOfAnimal + " znajduje się na pozycji: " + this.position.toString() + " i orientacji: "+ this.direction.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator) {

        switch (direction) {
            case RIGHT:
                this.direction = this.direction.next();
                break;

            case LEFT:
                this.direction = this.direction.previous();
                break;

            case FORWARD:
                Vector2d newPositionF = this.position.add(this.direction.toUnitVector());
                if(validator.canMoveTo(newPositionF) ){
                    this.position = newPositionF;
                }
                break;

            case BACKWARD:
                Vector2d newPositionB=this.position.subtract(this.direction.toUnitVector());
                if(validator.canMoveTo(newPositionB)) {
                    this.position = newPositionB;
                }
                break;

            default:
                break;
        }
    }

}
