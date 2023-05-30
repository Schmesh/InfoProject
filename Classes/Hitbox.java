package Classes;

class Hitbox{
    RegularPolygon polygon;
    double height;

    Point pos;

    Hitbox(int numberSides, double radius, double posX, double posY, double posZ, double height){
        polygon = new RegularPolygon( numberSides,  radius,  posX,  posY);
        this.height = height;
        pos.setXyz(posX,posY,posZ);
    }
}

