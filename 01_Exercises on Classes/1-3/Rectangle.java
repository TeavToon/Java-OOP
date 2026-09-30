class Rectangle {
    private float length;
    private float width;

    public Rectangle() {
        this.length = 1.0f;
        this.width = 1.0f;
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative" + length);
        }
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be non-negative" + width);
        }
        this.width = width;
    }

    public float getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public String toString() {
        return "Rectangle [length=" + length + ", width=" + width + "]";
    }
    
}