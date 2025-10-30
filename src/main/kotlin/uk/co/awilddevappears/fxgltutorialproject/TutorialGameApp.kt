package uk.co.awilddevappears.fxgltutorialproject

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.app.GameSettings
import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.dsl.getGameWorld
import com.almasb.fxgl.entity.components.CollidableComponent
import com.almasb.fxgl.physics.CollisionHandler
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.text.Text


class TutorialGameApp : GameApplication() {
    override fun initSettings(settings: GameSettings) {
        settings.width = 600
        settings.height = 600
        settings.title = "Tutorial game"
        settings.version = "0.0.1"
    }

    override fun initGame() {
        getGameWorld().addEntity(GameState.playerEntity)

        FXGL.entityBuilder()
            .type(EEntityTypes.COIN)
            .at(500.0, 200.0)
            .viewWithBBox(Circle(15.0, 15.0, 15.0, Color.YELLOW))
            .with(CollidableComponent(true))
            .buildAndAttach()
    }

    override fun initInput() {
        GameState.keybinds.entries.forEach { FXGL.onKey(it.key, it.value) }
    }

    override fun initUI() {
        val textPixels = Text()
        textPixels.translateX = 50.0
        textPixels.translateY = 100.0

        textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());

        FXGL.getGameScene().addUINode(textPixels)
    }

    override fun initGameVars(vars: MutableMap<String?, Any?>) {
        vars["pixelsMoved"] = 0
    }

    override fun initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(object: CollisionHandler(EEntityTypes.PLAYER, EEntityTypes.COIN) {
            override fun onCollisionBegin(player: com.almasb.fxgl.entity.Entity?, coin: com.almasb.fxgl.entity.Entity?) {
                coin?.removeFromWorld()
            }
        })
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(TutorialGameApp::class.java, args)
        }
    }
}
