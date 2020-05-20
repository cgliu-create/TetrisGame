import pygame
import tetris


class gui:
    def __init__(self):
        pygame.init()
        game = tetris.Game()
        win = pygame.display.set_mode((game.gameData.width, game.gameData.height))
        running = True
        clock = pygame.time.Clock()
        while running:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    running = False
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_LEFT:
                        game.moveShapeLeft()
                    if event.key == pygame.K_RIGHT:
                        game.moveShapeRight()
                    if event.key == pygame.K_UP:
                        game.rotate()
                    if event.key == pygame.K_DOWN:
                        game.moveShapeDown()
            game.update()
            if game.checkGameOver(game.gameData.numY-1):
                running = False
            game.gameData.displayGrid(win)
            pygame.display.update()
            time = clock.tick(4)
        pygame.quit()


if __name__ == '__main__':
    run = gui()
