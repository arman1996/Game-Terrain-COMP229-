# Game-Terrain-COMP229-
Watch "assignment one 229 2018.mp4" for details.

## Assignment One

In this assignment you must improve the graphics of your basic grid. You should start from the solution to Task 6. You may use your solution or the one published in the workshop repository.

## Pass Level

A grid represents a field, have the cells drawn in different shades of green.  The various shades of green are representing different heights of grass.  Your randomly chosen shades of green should also include randomly chosen red and blue components, although those will be smaller values naturally.  For full marks you must have either a color or a grass height field in your Cell class that is used for the drawing of the cell.

## Credit Level

Have a tool-tip appear near the mouse showing the height of the grass on that location. The tool tip should not show up when the mouse is off the grid.  The calculation for relating grass height to cell colour is: take the green component of the cell colour (i.e. a value between 0 and 255); divide (integer division) that number by 50; the result is the grass height (in meters).

## (High) Distinction Level: 🤔

Rather than the tool tip always being visible, have it only show up when the mouse has been still for a second or two.  It is not vital that timing is consistent, you are welcome to use the number of calls to paint as a proxy for a clock-tick.
