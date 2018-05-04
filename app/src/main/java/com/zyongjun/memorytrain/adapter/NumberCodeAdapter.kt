package com.zyongjun.memorytrain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.ibos.extensions.le
import com.zyongjun.memorytrain.R
import kotlinx.android.synthetic.main.item_number_code.view.*
import org.json.JSONObject



/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
data class CodeModel(var url:String,var title:String,val imgRes:Int = R.mipmap.cn_0)
class NumberCodeAdapter()
    : RecyclerView.Adapter<NumberCodeAdapter.CardHolder>(){
    val mCodeList = arrayListOf<CodeModel>()
   

    override fun getItemCount(): Int = mCodeList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_number_code, parent, false))
    }


    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bindData(mCodeList,position)
    }

    class CardHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindData(list:ArrayList<CodeModel>,position:Int) {
            itemView.tvNumberCode.setText(list[position].title)
            itemView.ivCode.setImageResource(list[position].imgRes)
        }
    }

    fun initData() {
        mCodeList.clear()
        val jsonObj = JSONObject(json)
        val array = jsonObj.getJSONArray("list")
        for (i in 0..array.length() - 1) {
            val objJson = array.optJSONObject(i)
            le("-----index --$i----url: ${objJson.optString("url")}----title:${objJson.optString("title")}----img--${getImgRes(objJson.optString("url"))}")
            mCodeList.add(CodeModel(objJson.optString("url"),objJson.optString("title"),getImgRes(objJson.optString("url"))))
        }
    }

    fun getImgRes(url:String):Int {
        var result = R.mipmap.cn_0
        try {
            val field = R.mipmap::class.java.getDeclaredField("cn_$url")
            result = field.get(null) as Int
        } catch (e: Exception) {
            le("${e.message}")
        }
        return result
    }


    val json = "{\n" +
            "  \"list\": [\n" +
            "    {\n" +
            "      \"url\": \"0\",\n" +
            "      \"title\": \"0.鸭蛋\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"1\",\n" +
            "      \"title\": \"1.铅笔\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"2\",\n" +
            "      \"title\": \"2.鸭子\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"3\",\n" +
            "      \"title\": \"3.耳朵\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"4\",\n" +
            "      \"title\": \"4.旗子\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"5\",\n" +
            "      \"title\": \"5.钩子\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"6\",\n" +
            "      \"title\": \"6.勺子\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"7\",\n" +
            "      \"title\": \"7.拐杖\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"8\",\n" +
            "      \"title\": \"8.葫芦\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"9\",\n" +
            "      \"title\": \"9.猫\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"10\",\n" +
            "      \"title\": \"10.棒球\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"11\",\n" +
            "      \"title\": \"11.筷子\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"12\",\n" +
            "      \"title\": \"12.椅儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"13\",\n" +
            "      \"title\": \"13.医生\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"14\",\n" +
            "      \"title\": \"14.钥匙\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"15\",\n" +
            "      \"title\": \"15.鹦鹉\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"16\",\n" +
            "      \"title\": \"16.石榴\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"17\",\n" +
            "      \"title\": \"17.仪器\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"18\",\n" +
            "      \"title\": \"18.要发\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"19\",\n" +
            "      \"title\": \"19.药酒\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"20\",\n" +
            "      \"title\": \"20.香烟\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"21\",\n" +
            "      \"title\": \"21.鳄鱼\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"22\",\n" +
            "      \"title\": \"22.双喜\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"23\",\n" +
            "      \"title\": \"23.耳塞\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"24\",\n" +
            "      \"title\": \"24.闹钟\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"25\",\n" +
            "      \"title\": \"25.二胡\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"26\",\n" +
            "      \"title\": \"26.河流\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"27\",\n" +
            "      \"title\": \"27.耳机\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"28\",\n" +
            "      \"title\": \"28.恶霸\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"29\",\n" +
            "      \"title\": \"29.按钮\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"30\",\n" +
            "      \"title\": \"30.三轮车\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"31\",\n" +
            "      \"title\": \"31.鲨鱼\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"32\",\n" +
            "      \"title\": \"32.扇儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"33\",\n" +
            "      \"title\": \"33.闪闪\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"34\",\n" +
            "      \"title\": \"34.绅士\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"35\",\n" +
            "      \"title\": \"35.珊瑚\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"36\",\n" +
            "      \"title\": \"36.山鹿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"37\",\n" +
            "      \"title\": \"37.山鸡\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"38\",\n" +
            "      \"title\": \"38.女人\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"39\",\n" +
            "      \"title\": \"39.三九感冒灵\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"40\",\n" +
            "      \"title\": \"40.司令\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"41\",\n" +
            "      \"title\": \"41.司仪\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"42\",\n" +
            "      \"title\": \"42.柿儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"43\",\n" +
            "      \"title\": \"43.石山\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"44\",\n" +
            "      \"title\": \"44.蛇\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"45\",\n" +
            "      \"title\": \"45.师傅\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"46\",\n" +
            "      \"title\": \"46.饲料\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"47\",\n" +
            "      \"title\": \"47.司机\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"48\",\n" +
            "      \"title\": \"48.石斑鱼\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"49\",\n" +
            "      \"title\": \"49.毛泽东\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"50\",\n" +
            "      \"title\": \"50.武林盟主\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"51\",\n" +
            "      \"title\": \"51.工人\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"52\",\n" +
            "      \"title\": \"52.斧儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"53\",\n" +
            "      \"title\": \"53.武僧\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"54\",\n" +
            "      \"title\": \"54.青年节\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"55\",\n" +
            "      \"title\": \"55.火车\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"56\",\n" +
            "      \"title\": \"56.蜗牛\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"57\",\n" +
            "      \"title\": \"57.武器\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"58\",\n" +
            "      \"title\": \"58.同城\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"59\",\n" +
            "      \"title\": \"59.五角\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"60\",\n" +
            "      \"title\": \"60.榴莲\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"61\",\n" +
            "      \"title\": \"61.儿童节\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"62\",\n" +
            "      \"title\": \"62.柳儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"63\",\n" +
            "      \"title\": \"63.流沙\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"64\",\n" +
            "      \"title\": \"64.螺丝\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"65\",\n" +
            "      \"title\": \"65.锣鼓\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"66\",\n" +
            "      \"title\": \"66.溜溜球\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"67\",\n" +
            "      \"title\": \"67.油漆\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"68\",\n" +
            "      \"title\": \"68.喇叭\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"69\",\n" +
            "      \"title\": \"69.八卦\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"70\",\n" +
            "      \"title\": \"70.冰淇淋\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"71\",\n" +
            "      \"title\": \"71.奇异果\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"72\",\n" +
            "      \"title\": \"72.企鹅\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"73\",\n" +
            "      \"title\": \"73.旗杆\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"74\",\n" +
            "      \"title\": \"74.骑士\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"75\",\n" +
            "      \"title\": \"75.西湖\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"76\",\n" +
            "      \"title\": \"76.气流\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"77\",\n" +
            "      \"title\": \"77.机器人\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"78\",\n" +
            "      \"title\": \"78.青蛙\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"79\",\n" +
            "      \"title\": \"79.气球\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"80\",\n" +
            "      \"title\": \"80.巴黎铁塔\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"81\",\n" +
            "      \"title\": \"81.白蚁\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"82\",\n" +
            "      \"title\": \"82.靶儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"83\",\n" +
            "      \"title\": \"83.花生\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"84\",\n" +
            "      \"title\": \"84.巴士\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"85\",\n" +
            "      \"title\": \"85.白虎\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"86\",\n" +
            "      \"title\": \"86.白兔\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"87\",\n" +
            "      \"title\": \"87.白棋\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"88\",\n" +
            "      \"title\": \"88.爸爸\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"89\",\n" +
            "      \"title\": \"89.白酒\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"90\",\n" +
            "      \"title\": \"90.酒瓶\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"91\",\n" +
            "      \"title\": \"91.球衣\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"92\",\n" +
            "      \"title\": \"92.球儿\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"93\",\n" +
            "      \"title\": \"93.旧伞\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"94\",\n" +
            "      \"title\": \"94.调酒师\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"95\",\n" +
            "      \"title\": \"95.救护车\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"96\",\n" +
            "      \"title\": \"96.九牛\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"97\",\n" +
            "      \"title\": \"97.脚气\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"98\",\n" +
            "      \"title\": \"98.球拍\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"99\",\n" +
            "      \"title\": \"99.玫瑰\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"url\": \"00\",\n" +
            "      \"title\": \"00.望远镜\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}