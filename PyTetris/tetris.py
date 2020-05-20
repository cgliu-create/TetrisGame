import grid
import shapes
import random


class Game:
    def __init__(self):
        
        self.gameData = grid.BlockGrid(10, 25, margin=5, swidth=25, sheight=25)
        self.jshape = shapes.JShape()
        self.lshape = shapes.LShape()
        self.lineshape = shapes.LineShape()
        self.squareshape = shapes.SquareShape()
        self.sshape = shapes.SShape()
        self.zshape = shapes.ZShape()
        self.tshape = shapes.TShape()
        self.curShape = 0
        self.addShape()
        self.drawShape()

    def getShape(self, num=0):
        allTheShapes = {
            1: self.jshape,
            2: self.lshape,
            3: self.lineshape,
            4: self.squareshape,
            5: self.sshape,
            6: self.zshape,
            7: self.tshape
        }
        return allTheShapes.get(num)

    def addShape(self):
        selection = random.randint(1, 7)
        self.curShape = selection
        self.getShape(selection).reset()

    def drawShape(self):
        shape = self.getShape(self.curShape)
        for blocks in shape.info.data:
            for block in blocks:
                if block.color != grid.black:
                    self.gameData.data[block.y][block.x].color = block.color

    def clearShape(self):
        for blocks in self.gameData.data:
            for block in blocks:
                if block.color != grid.black and block.color != grid.gray:
                    block.color = grid.black

    def clearSupport(self):
        for blocks in self.gameData.data:
            for block in blocks:
                if block.color == grid.white:
                    block.color = grid.black

    def loseShape(self):
        self.clearSupport()
        for blocks in self.gameData.data:
            for block in blocks:
                if block.color != grid.black and block.color != grid.gray and block.color != grid.white:
                    block.color = grid.gray
        self.addShape()
        self.drawShape()

    def checkCollisionBottom(self):
        for x in range(self.gameData.numX):
            block = self.gameData.data[self.gameData.numY - 1][x]
            if block.color == grid.white:
                self.clearSupport()
            if block.color != grid.black and block.color != grid.gray and block.color != grid.white:
                self.loseShape()

    def checkCollisionOther(self):
        for y in range(self.gameData.numY - 1, -1, -1):
            for x in range(self.gameData.numX):
                if self.gameData.data[y][x].color == grid.gray:
                    block = self.gameData.data[y - 1][x]
                    if block.color == grid.white:
                        self.clearSupport()
                    if block.color != grid.black and block.color != grid.gray and block.color != grid.white:
                        self.loseShape()

    def rowDelete(self, row=0):
        for y in range(row, -1, -1):
            for x in range(self.gameData.numX):
                if y - 1 >= 0:
                    self.gameData.data[y][x].color = self.gameData.data[y - 1][x].color

    def checkFullRow(self):
        for y in range(self.gameData.numY - 1, -1, -1):
            count = 0
            for x in range(self.gameData.numX):
                if self.gameData.data[y][x].color == grid.gray:
                    count += 1
            if count == self.gameData.numX:
                self.rowDelete(y)

    def checkGameOver(self, y):
        if y == 0:
            return True
        for x in range(self.gameData.numX):
            if self.gameData.data[y][x].color != grid.black:
                y -= 1
                return self.checkGameOver(y)
        return False

    def moveShapeLeft(self):
        self.checkCollisionOther()
        self.checkCollisionBottom()
        self.getShape(self.curShape).moveLeft(1)
        for x in range(1, self.gameData.numX):
            for y in range(self.gameData.numY - 1, -1, -1):
                if self.gameData.data[y][x].color != grid.black and self.gameData.data[y][x].color != grid.gray:
                    if self.gameData.data[y][x-1].color == grid.black:
                        self.gameData.data[y][x-1].color = self.gameData.data[y][x].color
                        self.gameData.data[y][x].color = grid.black

    def moveShapeRight(self):
        self.checkCollisionOther()
        self.checkCollisionBottom()
        self.getShape(self.curShape).moveRight(1, self.gameData.numX)
        for x in range(self.gameData.numX - 2, -1, -1):
            for y in range(self.gameData.numY - 1, -1, -1):
                if self.gameData.data[y][x].color != grid.black and self.gameData.data[y][x].color != grid.gray:
                    if self.gameData.data[y][x + 1].color == grid.black:
                        self.gameData.data[y][x + 1].color = self.gameData.data[y][x].color
                        self.gameData.data[y][x].color = grid.black

    def moveShapeDown(self):
        self.checkCollisionOther()
        self.checkCollisionBottom()
        self.getShape(self.curShape).moveDown(1)
        for y in range(self.gameData.numY-2, -1, -1):
            for x in range(self.gameData.numX):
                if self.gameData.data[y][x].color != grid.black and self.gameData.data[y][x].color != grid.gray:
                    self.gameData.data[y+1][x].color = self.gameData.data[y][x].color
                    self.gameData.data[y][x].color = grid.black

    def rotate(self):
        self.getShape(self.curShape).rot()
        self.clearShape()
        self.drawShape()

    def update(self):
        self.moveShapeDown()
        self.checkFullRow()
