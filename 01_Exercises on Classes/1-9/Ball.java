public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    // Constructor เดิม (รับ xDelta, yDelta ตรงๆ)
    public Ball(float x, float y, int radius, float xDelta, float yDelta) {
        this.x = x;
        this.y = y;
        setRadius(radius);
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    // Constructor ใหม่: รับ speed และ direction (องศา) ตามโจทย์
    public Ball(float x, float y, int radius, int speed, int directionInDegree) {
        this.x = x;
        this.y = y;
        setRadius(radius);
        
        // แปลงองศาเป็นเรเดียน
        double radian = Math.toRadians(directionInDegree);
        
        // คำนวณ delta-x และ delta-y
        this.xDelta = (float) (speed * Math.cos(radian));
        this.yDelta = (float) (-speed * Math.sin(radian)); // ติดลบเนื่องจากแกน Y ของจอลดลงเมื่อขึ้นข้างบน
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive: " + radius);
        }
        this.radius = radius;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return String.format("Ball[(%.1f, %.1f), speed=(%.1f, %.1f)]", x, y, xDelta, yDelta);
    }
}