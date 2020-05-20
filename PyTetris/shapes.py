import grid


class shape:
    def __init__(self):
        self.info = grid.BlockGrid(4, 4, margin=5, swidth=25, sheight=25)
        self.curRot = 1

    def moveLeft(self, x=0):
        for yp in range(self.info.numY):
            for xp in range(self.info.numX - 1, -1, -1):
                xpos = self.info.data[yp][xp].x
                if xpos - x < 0:
                    self.info.data[yp][xp].x = 0
                    self.info.data[yp][xp + 1].x = 1
                    self.info.data[yp][xp + 2].x = 2
                    self.info.data[yp][xp + 3].x = 3
                else:
                    self.info.data[yp][xp].x -= x

    def moveRight(self, x=0, b=0):
        for yp in range(self.info.numY):
            for xp in range(self.info.numX):
                xpos = self.info.data[yp][xp].x
                if xpos + x >= b:
                    self.info.data[yp][xp].x = b-1
                    self.info.data[yp][xp - 1].x = b-2
                    self.info.data[yp][xp - 2].x = b-3
                    self.info.data[yp][xp - 3].x = b-4
                else:
                    self.info.data[yp][xp].x += x

    def moveDown(self, y=0):
        for yp in range(self.info.numY):
            for xp in range(self.info.numX):
                self.info.data[yp][xp].y += y

    def reset(self):
        self.rotOne()
        for yp in range(self.info.numY):
            for xp in range(self.info.numX):
                block = self.info.data[yp][xp]
                block.x = xp
                block.y = yp

    def removewhite(self):
        for blocks in self.info.data:
            for block in blocks:
                if block.color == grid.white:
                    block.color = grid.black

    def rotOne(self):
        pass

    def rotTwo(self):
        pass

    def rotThree(self):
        pass

    def rotFour(self):
        pass

    def rot(self):
        self.curRot += 1
        if self.curRot == 5:
            self.curRot = 1
        if self.curRot == 1:
            self.rotOne()
        if self.curRot == 2:
            self.rotTwo()
        if self.curRot == 3:
            self.rotThree()
        if self.curRot == 4:
            self.rotFour()


class JShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.red), self.info.markGrid(0, 2, grid.red)
        self.info.markGrid(1, 1, grid.red), self.info.markGrid(2, 1, grid.red)
        self.info.markGrid(1, 2, grid.white), self.info.markGrid(2, 2, grid.white)

    def rotTwo(self):
        self.info.resetGrid()
        self.info.markGrid(1, 0, grid.red), self.info.markGrid(1, 1, grid.red)
        self.info.markGrid(1, 2, grid.red), self.info.markGrid(2, 2, grid.red)
        self.info.markGrid(2, 0, grid.white), self.info.markGrid(2, 1, grid.white)

    def rotThree(self):
        self.info.resetGrid()
        self.info.markGrid(2, 0, grid.red), self.info.markGrid(0, 1, grid.red)
        self.info.markGrid(1, 1, grid.red), self.info.markGrid(2, 1, grid.red)
        self.info.markGrid(0, 0, grid.white), self.info.markGrid(1, 0, grid.white)

    def rotFour(self):
        self.info.resetGrid()
        self.info.markGrid(0, 0, grid.red),  self.info.markGrid(1, 0, grid.red)
        self.info.markGrid(1, 1, grid.red), self.info.markGrid(1, 2, grid.red)
        self.info.markGrid(0, 1, grid.white), self.info.markGrid(0, 2, grid.white)


class LShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(0, 0, grid.blue), self.info.markGrid(0, 1, grid.blue)
        self.info.markGrid(1, 1, grid.blue), self.info.markGrid(2, 1, grid.blue)
        self.info.markGrid(1, 0, grid.white), self.info.markGrid(2, 0, grid.white)

    def rotTwo(self):
        self.info.resetGrid()
        self.info.markGrid(0, 2, grid.blue), self.info.markGrid(1, 0, grid.blue)
        self.info.markGrid(1, 1, grid.blue), self.info.markGrid(1, 2, grid.blue)
        self.info.markGrid(0, 0, grid.white), self.info.markGrid(0, 1, grid.white)

    def rotThree(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.blue), self.info.markGrid(1, 1, grid.blue)
        self.info.markGrid(2, 1, grid.blue), self.info.markGrid(2, 2, grid.blue)
        self.info.markGrid(0, 2, grid.white), self.info.markGrid(1, 2, grid.white)

    def rotFour(self):
        self.info.resetGrid()
        self.info.markGrid(2, 0, grid.blue), self.info.markGrid(1, 0, grid.blue)
        self.info.markGrid(1, 1, grid.blue), self.info.markGrid(1, 2, grid.blue)
        self.info.markGrid(2, 1, grid.white), self.info.markGrid(2, 2, grid.white)


class LineShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.green), self.info.markGrid(1, 1, grid.green)
        self.info.markGrid(2, 1, grid.green), self.info.markGrid(3, 1, grid.green)

    def rotTwo(self):
        self.info.resetGrid()
        self.info.markGrid(1, 0, grid.green), self.info.markGrid(1, 1, grid.green)
        self.info.markGrid(1, 2, grid.green), self.info.markGrid(1, 3, grid.green)

    def rotThree(self):
        self.info.resetGrid()
        self.info.markGrid(0, 2, grid.green), self.info.markGrid(1, 2, grid.green)
        self.info.markGrid(2, 2, grid.green), self.info.markGrid(3, 2, grid.green)

    def rotFour(self):
        self.info.resetGrid()
        self.info.markGrid(2, 0, grid.green), self.info.markGrid(2, 1, grid.green)
        self.info.markGrid(2, 2, grid.green), self.info.markGrid(2, 3, grid.green)


class SquareShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rot(self, turnR=False, turnL=False):
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(1, 1, grid.orange), self.info.markGrid(1, 2, grid.orange)
        self.info.markGrid(2, 1, grid.orange), self.info.markGrid(2, 2, grid.orange)


class SShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(0, 0, grid.yellow), self.info.markGrid(1, 0, grid.yellow)
        self.info.markGrid(1, 1, grid.yellow), self.info.markGrid(2, 1, grid.yellow)
        self.info.markGrid(2, 0, grid.white), self.info.markGrid(0, 1, grid.white)

    def rotTwo(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.yellow), self.info.markGrid(0, 2, grid.yellow)
        self.info.markGrid(1, 0, grid.yellow), self.info.markGrid(1, 1, grid.yellow)
        self.info.markGrid(0, 0, grid.white), self.info.markGrid(1, 2, grid.white)

    def rotThree(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.yellow), self.info.markGrid(1, 1, grid.yellow)
        self.info.markGrid(1, 2, grid.yellow), self.info.markGrid(2, 2, grid.yellow)
        self.info.markGrid(0, 2, grid.white), self.info.markGrid(2, 1, grid.white)

    def rotFour(self):
        self.info.resetGrid()
        self.info.markGrid(1, 1, grid.yellow), self.info.markGrid(1, 2, grid.yellow)
        self.info.markGrid(2, 0, grid.yellow), self.info.markGrid(2, 1, grid.yellow)
        self.info.markGrid(1, 0, grid.white), self.info.markGrid(2, 2, grid.white)


class ZShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.pink), self.info.markGrid(1, 1, grid.pink)
        self.info.markGrid(1, 0, grid.pink), self.info.markGrid(2, 0, grid.pink)
        self.info.markGrid(0, 0, grid.white), self.info.markGrid(2, 1, grid.white)

    def rotTwo(self):
        self.info.resetGrid()
        self.info.markGrid(0, 0, grid.pink), self.info.markGrid(0, 1, grid.pink)
        self.info.markGrid(1, 1, grid.pink), self.info.markGrid(1, 2, grid.pink)
        self.info.markGrid(1, 0, grid.white), self.info.markGrid(0, 2, grid.white)

    def rotThree(self):
        self.info.resetGrid()
        self.info.markGrid(0, 2, grid.pink), self.info.markGrid(1, 2, grid.pink)
        self.info.markGrid(1, 1, grid.pink), self.info.markGrid(2, 1, grid.pink)
        self.info.markGrid(0, 1, grid.white), self.info.markGrid(2, 2, grid.white)

    def rotFour(self):
        self.info.resetGrid()
        self.info.markGrid(1, 0, grid.pink), self.info.markGrid(1, 1, grid.pink)
        self.info.markGrid(2, 1, grid.pink), self.info.markGrid(2, 2, grid.pink)
        self.info.markGrid(2, 0, grid.white), self.info.markGrid(1, 2, grid.white)


class TShape(shape):
    def __init__(self):
        shape.__init__(self)
        self.rotOne()

    def rotOne(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.purple), self.info.markGrid(1, 0, grid.purple)
        self.info.markGrid(1, 1, grid.purple), self.info.markGrid(1, 2, grid.purple)
        self.info.markGrid(0, 0, grid.white), self.info.markGrid(0, 2, grid.white)

    def rotTwo(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.purple), self.info.markGrid(1, 1, grid.purple)
        self.info.markGrid(2, 1, grid.purple), self.info.markGrid(1, 2, grid.purple)
        self.info.markGrid(0, 2, grid.white), self.info.markGrid(2, 2, grid.white)

    def rotThree(self):
        self.info.resetGrid()
        self.info.markGrid(1, 0, grid.purple), self.info.markGrid(1, 1, grid.purple)
        self.info.markGrid(1, 2, grid.purple), self.info.markGrid(2, 1, grid.purple)
        self.info.markGrid(2, 0, grid.white), self.info.markGrid(2, 2, grid.white)

    def rotFour(self):
        self.info.resetGrid()
        self.info.markGrid(0, 1, grid.purple), self.info.markGrid(1, 1, grid.purple)
        self.info.markGrid(2, 1, grid.purple), self.info.markGrid(1, 0, grid.purple)
        self.info.markGrid(0, 0, grid.white), self.info.markGrid(2, 0, grid.white)
