package com.mofang.feedweb.util;

import java.util.HashMap;
import java.util.Map;

public class EmojiUtil {

	private static final Map<String, String> EMOJIMAP = new HashMap<String, String>();

	static {
		EMOJIMAP.put("嘻哈",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiaha_9481465.png");
		EMOJIMAP.put("龇牙",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_ziya_2c94900.png");
		EMOJIMAP.put("受伤",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shoushang_56c02f5.png");
		EMOJIMAP.put("大笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_daxiao_85572c2.png");
		EMOJIMAP.put("开心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kaixin_e68274a.png");
		EMOJIMAP.put("笑汗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiaohan_50f11c1.png");
		EMOJIMAP.put("讥笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jixiao_90dac1b.png");
		EMOJIMAP.put("天使",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tianshi_dba4be0.png");
		EMOJIMAP.put("恶魔",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_emo_b5f33d7.png");
		EMOJIMAP.put("挑逗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tiaodou_eb53a90.png");
		EMOJIMAP.put("可爱",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_keai_cfb4134.png");
		EMOJIMAP.put("微笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_weixiao_66df40a.png");
		EMOJIMAP.put("满意",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_manyi_f7b49a1.png");
		EMOJIMAP.put("色心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_sexin_3138a3a.png");
		EMOJIMAP.put("得意",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_deyi_ea1cd7e.png");
		EMOJIMAP.put("阴险",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_yinxian_dfc8dad.png");
		EMOJIMAP.put("平静",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_pingjing_42af35a.png");
		EMOJIMAP.put("淡定",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_danding_f0af606.png");
		EMOJIMAP.put("斜视",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xishi_2819ad6.png");
		EMOJIMAP.put("尴尬",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_ganga_4156747.png");
		EMOJIMAP.put("失望",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shiwang_f2f843c.png");
		EMOJIMAP.put("傲慢",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_aoman_a9dc4e2.png");
		EMOJIMAP.put("撇嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_pizui_5924bde.png");
		EMOJIMAP.put("喜欢",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xihuan_8be7916.png");
		EMOJIMAP.put("飞吻",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_feiwen_5e1d111.png");
		EMOJIMAP.put("喜爱",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiai_7e90fa9.png");
		EMOJIMAP.put("亲嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_qinzui_670ec07.png");
		EMOJIMAP.put("快乐",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kuaile_346ffba.png");
		EMOJIMAP.put("调皮",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tiaopi_ba4c7ba.png");
		EMOJIMAP.put("吐舌",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tushe_d64a42a.png");
		EMOJIMAP.put("失落",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shiluo_c051da6.png");
		EMOJIMAP.put("伤心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shangxin_5280e71.png");
		EMOJIMAP.put("发怒",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_fanu_edff1ca.png");
		EMOJIMAP.put("生气",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shengqi_1e5cee8.png");
		EMOJIMAP.put("纠结",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jiujie_ce8fe76.png");
		EMOJIMAP.put("喷气",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_penqi_03b4ddc.png");
		EMOJIMAP.put("汗呐",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_hanna_eaade91.png");
		EMOJIMAP.put("张嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_zhangzui_e0b1c6c.png");
		EMOJIMAP.put("意外",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_yiwai_aa26189.png");
		EMOJIMAP.put("恐怖",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kongbu_c8b5f71.png");
		EMOJIMAP.put("大哭",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_daku_c4cf035.png");
		EMOJIMAP.put("生病",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shengbin_2f18be2.png");
		EMOJIMAP.put("难过",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_naguo_6ac90c6.png");
		EMOJIMAP.put("挤笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jixiao_45_9cbbeb0.png");
		EMOJIMAP.put("流泪",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_liulei_e82b024.png");
		EMOJIMAP.put("惊讶",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jingya_f4d3f19.png");
		EMOJIMAP.put("期待",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_qidai_230ebe0.png");
		EMOJIMAP.put("冷汗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lenghan_e14a9f1.png");
		EMOJIMAP.put("惊悚",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jingsun_5c05f23.png");
		EMOJIMAP.put("拒绝",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jujue_e3c96db.png");
		EMOJIMAP.put("脸红",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lianhong_595f92f.png");
		EMOJIMAP.put("睡觉",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shuijiao_b83bb83.png");
		EMOJIMAP.put("冷静",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lengjing_4a97155.png");
		EMOJIMAP.put("口罩",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kouzhao_02c0354.png");
	}
	
	public static Map<String, String> getEmojiMap() {
		return EMOJIMAP;
	}
}
