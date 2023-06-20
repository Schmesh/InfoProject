package Classes;

class Hitbox{
    public RegularPolygon base;
    public double height;

    public double direction = 0;

    public Point pos = new Point(new double[]{0,0,0});

    Hitbox(int numberSides, double radius, double posX, double posY, double posZ, double height){
        base = new RegularPolygon( numberSides,  radius,  posX,  posY);
        this.height = height;
        pos.setXyz(posX,posY,posZ);
    }

    public void move(double dx, double dy, double dz){
        pos.move(dx,dy,dz);
        base.move(dx,dy);
    }

    public void moveTo(Point pos){
        pos.setXyz(pos.getXYZ());
        base.moveTo(pos);
    }

    public void setDirection(double direction){
        this.direction = direction;
        base.setDirection(direction);
    }

    public void rotate(double angle){
        direction = angle;
        base.rotate(angle);
    }

    public Point getPos(){
        return pos;
    }

    public double getZ(){
        return pos.getZ();
    }

    public void setX(double x){
        pos.setX(x);
        base.x = x;
    }

    public void setY(double y){
        pos.setY(y);
        base.y = y;
    }

    public void setZ(double z){
        pos.setZ(z);
    }
}

