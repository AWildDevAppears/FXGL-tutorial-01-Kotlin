package uk.co.awilddevappears.fxgltutorialproject

import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.entity.Entity
import com.almasb.fxgl.entity.components.CollidableComponent
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

object GameState {
    val playerEntity: Entity = FXGL.entityBuilder()
            .type(EEntityTypes.PLAYER)
            .at(300.0,300.0)
            .viewWithBBox(Rectangle(25.0,25.0, Color.BLUE))
            .with(CollidableComponent(true))
            .build()

    private fun moveLeft() {
        playerEntity.translateX(-5.0)
        FXGL.inc("pixelsMoved", +5)
    }

    private fun moveRight() {
        GameState.playerEntity.translateX(5.0)
        FXGL.inc("pixelsMoved", +5)

    }

    private fun moveUp() {
        GameState.playerEntity.translateY(-5.0) // move right 5 pixels
        FXGL.inc("pixelsMoved", +5)
    }

    private fun moveDown() {
        GameState.playerEntity.translateY(5.0) // move right 5 pixels
        FXGL.inc("pixelsMoved", +5)
    }

    val keybinds = mapOf<KeyCode, () -> Unit>(
        Pair(KeyCode.D) { moveRight() },
        Pair(KeyCode.A) { moveLeft() },
        Pair(KeyCode.W) { moveUp() },
        Pair(KeyCode.S) { moveDown() }
    )
}