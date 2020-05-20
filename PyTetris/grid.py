import pygame


black = (0, 0, 0)
white = (255, 255, 255)
gray = (127, 127, 127)
red = (255, 0, 0)
blue = (0, 0, 255)
green = (0, 255, 0)
orange = (255, 100, 10)
yellow = (255, 255, 0)
pink = (255, 100, 180)
purple = (240, 0, 255)


class Block:
    def __init__(self, x=0, y=0, color=(0, 0, 0)):
        self.color = color
        self.x = x
        self.y = y


class BlockGrid:
    def __init__(self, numX=1, numY=1, margin=1, swidth=1, sheight=1):
        self.numX = numX
        self.numY = numY
        self.swidth = swidth
        self.sheight = sheight
        self.width = numX * (margin + swidth) + margin
        self.height = numY * (margin + sheight) + margin
        self.data = [[Block() for x in range(self.numX)] for y in range(self.numY)]
        for y in range(self.numY):
            for x in range(self.numX):
                xp = margin + x * (swidth + margin)
                yp = margin + y * (sheight + margin)
                self.data[y][x] = Block(xp, yp, (0, 0, 0))

    def resetGrid(self):
        for yp in range(self.numY):
            for xp in range(self.numX):
                self.data[yp][xp].color = (0, 0, 0)

    def markGrid(self, y=0, x=0, color=(0, 0, 0)):
        self.data[y][x].color = color

    def displayGrid(self, display):
        display.fill(white)
        for yp in range(self.numY):
            for xp in range(self.numX):
                p = self.data[yp][xp]
                color = p.color
                if color == white:
                    color = black
                pygame.draw.rect(display, color, (p.x, p.y, self.swidth, self.sheight))
