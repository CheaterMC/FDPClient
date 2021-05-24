package net.ccbluex.liquidbounce.features.module.modules.render

import net.ccbluex.liquidbounce.features.IntegerValue
import net.ccbluex.liquidbounce.features.ListValue
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.utils.render.ColorUtils
import net.ccbluex.liquidbounce.utils.render.RenderUtils
import java.awt.Color

@ModuleInfo(name = "EnchantEffect", description = "Change Enchant Effect Color", category = ModuleCategory.RENDER)
class EnchantEffect : Module() {
    private val redValue = IntegerValue("Red", 255, 0, 255)
    private val greenValue = IntegerValue("Green", 0, 0, 255)
    private val blueValue = IntegerValue("Blue", 0, 0, 255)
    private val modeValue = ListValue("Mode", arrayOf("Rainbow", "AnotherRainbow", "Custom"), "Custom")

    fun getColor():Color{
        return when(modeValue.get().toLowerCase()){
            "rainbow" -> ColorUtils.rainbow()
            "anotherrainbow" -> RenderUtils.skyRainbow(10,0.9F,1F,1.0)
            else -> Color(redValue.get(),greenValue.get(),blueValue.get())
        }
    }
}