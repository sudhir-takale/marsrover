# Mars Rover

_A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously rectangular, must be navigated by the rovers so that their
on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position and location is represented by a combination of x and y co-ordinates and a
letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify
navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner
and facing North. In order to control a rover, NASA sends a simple string of letters. The possible
letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively,
without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left
coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed
. Each rover has two lines of input. The first line gives the rover's position,
and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces,
corresponding to the x and y co-ordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start
to move until the first one has finished moving.

OUTPUT:
The output for each rover should be its final co-ordinates and heading.

INPUT AND OUTPUT:
Test Input:
5 5

1 2 N

LMLMLMLMM

3 3 E_

MMRMMRMRRM

Expected Output:
1 3 N

5 1 E

------------------------------------------------------------------------------------------------------

#### Analysis

###### Assumptions:

- Plateau don't exist without rover

### Domain

## Model

- Coordinates - it is x and y coordinates of rover deployed on the mars
    - x
    - y
- Direction (enum) - it stores the direction of rover deployed on the mars
    - N, S, W, E

## Service

- Instruction Processor - it processes the request coming from the user
    - processInstruction(DeployedRoverDto, String Instruction)  - it takes these two parameters and process
      the move the rover according to instruction and after that returns the rover state

#### Controller

- RoverController - handles operation related with RoverController
    - createRover() - it will create rover
    - updateRover() - to update the state of rover
    - get(id)        - to get rover by id

- PlateauController - handles operation related with PlateauController
    - createPlateau(length , breadth) - with initial length and breadth it will create plateau
    - get(id)    - to get plateau by id
    - updatePlateau()  - update the plateau parameters with
    - deployRover(roverId, plateauId, Coordinates(x ,y), Direction) - it will help to deploy rover

- InstructionController - handles user input and help to instruct rover
    - processInstruction(roverId, instruction) - return the updated rover

#### Service

- RoverService - it helps in create rover related functionality
    - createRover()
    - get(id) - to get rover by id
    - update(RoverDto) - to update rover by id

- PlateauService
    - create(length, breadth) - it will create plateau
    - getPlateau(id)
    - updatePlateau(id)
    - deployRover(roverId, plateauId, coordinate, direction)

- InstructionService
    - processInstruction(roverId, instruction)
        - it will call to domain service to process the instruction and returns the updated rover

#### Repository

##### DTO

- RoverDto
    - id
    - isDeployed - boolean after deploy it will set to true

- PlateauDto -
    - id
    - length
    - breadth
    - List<RoverDto> rovers - it contains rovers which are deployed on this plateau

- DeployedRoverDto - it contains information of rover which is deployed on mars
    - roverId
    - Coordinates
    - Direction

#### Repository

- RoverRepository - it will store the rovers
    - save(RoverDto)
    - get(id)
    - update(RoverDto)

- PlateauRepository - it will store the plateau information
    - create(length, breadth)
    - update(PlateauDto)
    - get(id)

#### Database

- FakeInMemoryDatabase - used fake in memory database to store the information
- tables:
    - RoverTable - contains all the rovers
    - PlateauTable -
        - id
        - length, Breadth
        - List<DeployedRover> 
