package pong1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

public class Kulka {
    private static final double R = 10;
    protected double ySpeed;
    protected double xSpeed;
    protected double xPos;
    protected double yPos;

    protected Color color;

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

     Kulka(double xPos, double yPos, double xSpeed, double ySpeed){
         this.xPos = xPos;
         this.yPos = yPos;
         this.xSpeed = xSpeed;
         this.ySpeed = ySpeed;
         color = Color.WHITESMOKE;
     }

     public void checkBoundaryCollision(double xLeft, double yTop, double xRight, double yBottom){
         if ((xPos - R <= xLeft) || ((xPos + R >= xRight))){
             xSpeed=-xSpeed;
         }
         if ((yPos - R <= yTop) || ((yPos + R >= yBottom))){
             ySpeed=-ySpeed;
         }
     }

     @Override
     public void draw(GraphicsContext gc){
         gc.save();
         gc.setFill(color);
         gc.transform(new Affine(new Rotate(rot, xPos, yPos)));
         gc.fillOval(xPos - rx, yPos - ry, 2*rx, 2*ry);
         gc.restore();
     }

     @Override
     public void update(){
         super.update();
         rot += omega;
         System.out.printf("rotation: %f\n", rot);
     }

    protected double rx;
    protected double ry;
    protected double omega;
    protected double rot;

    public Rugby(double xPos, double yPos, double xSpeed, double ySpeed, double omega, double rx, double ry) {
        super(xPos, yPos, xSpeed, ySpeed);
        this.rx = rx;
        this.ry = ry;
        this.omega=omega;
    }
}
