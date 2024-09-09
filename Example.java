/**
 * An animation is made of a candy stand giving goods and then closing
 * 
 * @author (Tia Rice) 
 * @version (10/6/2022)
 */
public class Example
{
    // instance variables for almost all shapes
    Canvas canvas;
    Rect desk = new Rect();
    Rect label = new Rect();
    Rect lftColumn = new Rect();
    Rect rtColumn = new Rect();
    Rect roof = new Rect();
    Person worker = new Person();
    Rect sprinkle = new Rect();
    Rect sprinkleLid = new Rect();
    Rect season = new Rect();
    Rect seasonLid = new Rect();
    Rect sodaMachine = new Rect();
    Rect sodaDispenser = new Rect();
    Rect sodaDispenserTwo = new Rect();

    /**
     * Constructor for objects of class Example
     */
    public Example()
    {
        // magenta worked
        worker.changeColor("magenta");
        worker.changeSize(250,140);
        worker.moveVertical(100);
        
        //lower part of candy stand
        //changeSize1 changes x length
        desk.changeSize1(600);
        //changeSize2 changes y length
        desk.changeSize2(200);
        desk.moveHorizontal(-330);
        desk.moveVertical(260);
        desk.changeColor("black");
        
        // left column of candy stand
        lftColumn.moveHorizontal(-310);
        lftColumn.moveVertical(-50);
        lftColumn.changeColor("black");
        lftColumn.changeSize2(450);
        
        // right column of candy stand
        rtColumn.moveHorizontal(130);
        rtColumn.moveVertical(-50);
        rtColumn.changeColor("black");
        rtColumn.changeSize2(450);
        
        // roof of candy stand
        roof.moveVertical(-120);
        roof.moveHorizontal(-400);
        roof.changeColor("black");
        roof.changeSize1(600);
        roof.changeSize2(70);
        
        // white labell in the middle of desk of candy stand
        label.changeSize1(310);
        label.changeSize2(100);
        label.moveHorizontal(-200);
        label.moveVertical(270);
        label.changeColor("white");
        
        // sprinkles for candy
        sprinkle.changeColor("white");
        sprinkle.changeSize1(40);
        sprinkle.changeSize2(60);
        sprinkle.moveVertical(200);
        
        // lid of sprinkle jar
        sprinkleLid.changeColor("red");
        sprinkleLid.changeSize1(50);
        sprinkleLid.changeSize2(5);
        sprinkleLid.moveVertical(200);
        sprinkleLid.moveHorizontal(-5);
        
        // seasoning for candy
        season.changeColor("white");
        season.changeSize1(40);
        season.changeSize2(60);
        season.moveVertical(200);
        season.moveHorizontal(70);
        
        // lid for the seasoning of the candy
        seasonLid.changeColor("blue");
        seasonLid.changeSize1(50);
        seasonLid.changeSize2(5);
        seasonLid.moveVertical(200);
        seasonLid.moveHorizontal(65);
        
        // body of soda machine
        sodaMachine.changeSize1(150);
        sodaMachine.changeSize2(300);
        sodaMachine.moveHorizontal(-240);
        sodaMachine.moveVertical(60);
        sodaMachine.changeColor("black");
        
        // red dispenser of soda machine displayed on left
        sodaDispenser.changeSize1(20);
        sodaDispenser.changeSize2(30);
        sodaDispenser.changeColor("red");
        sodaDispenser.moveHorizontal(-200);
        sodaDispenser.moveVertical(70);
        
        // blue dispenser of soda machine displayed on right
        sodaDispenserTwo.changeSize1(20);
        sodaDispenserTwo.changeSize2(30);
        sodaDispenserTwo.changeColor("blue");
        sodaDispenserTwo.moveHorizontal(-150);
        sodaDispenserTwo.moveVertical(70);
        
        // making everything visible
        sodaMachine.makeVisible();
        sodaDispenser.makeVisible();
        sodaDispenserTwo.makeVisible();
        worker.makeVisible();
        desk.makeVisible();
        
        label.makeVisible();
        lftColumn.makeVisible();
        rtColumn.makeVisible();
        
        sprinkle.makeVisible();
        sprinkleLid.makeVisible();
        season.makeVisible();
        seasonLid.makeVisible();
        roof.makeVisible();
        
        // calling functions
        dispenseCola();
        buyCandy();
        closeShop();
    }
    
    public void closeShop()
    {
        // loop for end sequence were green and blue shutters come down and "close shop"
        for (int y = -50 ; y < 240; y= y + 15)
            {
                if (y%2 == 0)
                // y is used a variable so shutters move down on even numbers
                {
                    Rect newBlueShades = new Rect();
                    newBlueShades.changeSize1(380);
                    newBlueShades.changeSize2(20);
                    newBlueShades.changeColor("blue");
                    newBlueShades.moveHorizontal(-250);
                    newBlueShades.moveVertical(y);
                    newBlueShades.makeVisible();
                }
                else
                // if y is not even green shutters will be displayed
                {
                    Rect newGreenShades = new Rect();
                    newGreenShades.changeSize1(380);
                    newGreenShades.changeSize2(40);
                    newGreenShades.changeColor("green");
                    newGreenShades.moveHorizontal(-250);
                    // y+4 so shutters don't appear too close
                    newGreenShades.moveVertical(y+4);
                    newGreenShades.makeVisible();
                }
            }
    }
    public void buyCandy()
    {
        // makes basket for candy
        Rect basket = new Rect();
        basket.changeSize1(80);
        basket.changeSize2(70);
        basket.moveHorizontal(-200);
        basket.moveVertical(190);
        
        // worker moves left 
        worker.slowMoveHorizontal(-50);
        // instances made visible
        desk.makeVisible();
        label.makeVisible();
        basket.makeVisible();
        for (int x = 5; x<100; x++)
        {
            // loop for randomly generated candy
            double xDoubleRandomNumber = Math.random() * x;
            double yDoubleRandomNumber = Math.random() * x;
            // cast the double to whole number
            int xRandomNumber = (int)xDoubleRandomNumber;
            int yRandomNumber = (int)yDoubleRandomNumber;
            // candies are circles
            Circle candy = new Circle();
            candy.changeSize(10);
            // calculation for magenta and blue candy
            if (x%3 == 0)
            {
                candy.changeColor("magenta");
            }
            else
            {
                candy.changeColor("blue");
            }
            
            // candy is made visible and in a certain range and domain
            if (300<yRandomNumber)
            {
                candy.visible();
            }
            else
            {
                candy.moveHorizontal(xRandomNumber-120);
                candy.moveVertical(yRandomNumber+190);
                candy.makeVisible();
            }
        }
        
        // sprinkles move to hand of worker
        sprinkle.moveVertical(-10);
        sprinkleLid.moveVertical(-10);
        sprinkle.slowMoveHorizontal(-10);
        sprinkleLid.slowMoveHorizontal(-10);
    }
    public void dispenseCola()
    {
        // cup is made with different requirements
        Rect cup = new Rect();
        cup.changeColor("white");
        cup.moveVertical(160);
        cup.moveHorizontal(-150);
        cup.changeSize1(20);
        cup.changeSize2(30);
        cup.makeVisible();
        
        // soda that comes down is made
        Rect soda = new Rect();
        soda.changeColor("green");
        soda.changeSize1(10);
        soda.changeSize2(20);
        soda.moveVertical(130);
        soda.moveHorizontal(-145);
        soda.makeVisible();
        // animation for soda
        soda.slowMoveVertical(20);
        soda.makeInvisible();
        cup.changeColor("green");
        // animation for cup
        cup.slowMoveVertical(70);
        cup.slowMoveHorizontal(-85);
    }
}

