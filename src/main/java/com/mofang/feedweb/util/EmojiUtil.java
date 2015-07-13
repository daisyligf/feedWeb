package com.mofang.feedweb.util;

import java.util.HashMap;
import java.util.Map;

public class EmojiUtil {

	private static final Map<String, String> EMOJIMAPWEB = new HashMap<String, String>();

	private static final Map<String, String> EMOJIMAPAPP = new HashMap<String, String>();
	
	static {
		initEmojiMapWeb();
		initEmojiMapApp();
	}
	
	private static void initEmojiMapWeb() {
		EMOJIMAPWEB.put("嘻哈",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiaha_9481465.png");
		EMOJIMAPWEB.put("龇牙",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_ziya_2c94900.png");
		EMOJIMAPWEB.put("受伤",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shoushang_56c02f5.png");
		EMOJIMAPWEB.put("大笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_daxiao_85572c2.png");
		EMOJIMAPWEB.put("开心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kaixin_e68274a.png");
		EMOJIMAPWEB.put("笑汗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiaohan_50f11c1.png");
		EMOJIMAPWEB.put("讥笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jixiao_90dac1b.png");
		EMOJIMAPWEB.put("天使",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tianshi_dba4be0.png");
		EMOJIMAPWEB.put("恶魔",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_emo_b5f33d7.png");
		EMOJIMAPWEB.put("挑逗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tiaodou_eb53a90.png");
		EMOJIMAPWEB.put("可爱",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_keai_cfb4134.png");
		EMOJIMAPWEB.put("微笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_weixiao_66df40a.png");
		EMOJIMAPWEB.put("满意",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_manyi_f7b49a1.png");
		EMOJIMAPWEB.put("色心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_sexin_3138a3a.png");
		EMOJIMAPWEB.put("得意",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_deyi_ea1cd7e.png");
		EMOJIMAPWEB.put("阴险",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_yinxian_dfc8dad.png");
		EMOJIMAPWEB.put("平静",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_pingjing_42af35a.png");
		EMOJIMAPWEB.put("淡定",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_danding_f0af606.png");
		EMOJIMAPWEB.put("斜视",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xishi_2819ad6.png");
		EMOJIMAPWEB.put("尴尬",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_ganga_4156747.png");
		EMOJIMAPWEB.put("失望",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shiwang_f2f843c.png");
		EMOJIMAPWEB.put("傲慢",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_aoman_a9dc4e2.png");
		EMOJIMAPWEB.put("撇嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_pizui_5924bde.png");
		EMOJIMAPWEB.put("喜欢",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xihuan_8be7916.png");
		EMOJIMAPWEB.put("飞吻",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_feiwen_5e1d111.png");
		EMOJIMAPWEB.put("喜爱",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_xiai_7e90fa9.png");
		EMOJIMAPWEB.put("亲嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_qinzui_670ec07.png");
		EMOJIMAPWEB.put("快乐",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kuaile_346ffba.png");
		EMOJIMAPWEB.put("调皮",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tiaopi_ba4c7ba.png");
		EMOJIMAPWEB.put("吐舌",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_tushe_d64a42a.png");
		EMOJIMAPWEB.put("失落",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shiluo_c051da6.png");
		EMOJIMAPWEB.put("伤心",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shangxin_5280e71.png");
		EMOJIMAPWEB.put("发怒",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_fanu_edff1ca.png");
		EMOJIMAPWEB.put("生气",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shengqi_1e5cee8.png");
		EMOJIMAPWEB.put("纠结",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jiujie_ce8fe76.png");
		EMOJIMAPWEB.put("喷气",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_penqi_03b4ddc.png");
		EMOJIMAPWEB.put("汗呐",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_hanna_eaade91.png");
		EMOJIMAPWEB.put("张嘴",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_zhangzui_e0b1c6c.png");
		EMOJIMAPWEB.put("意外",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_yiwai_aa26189.png");
		EMOJIMAPWEB.put("恐怖",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kongbu_c8b5f71.png");
		EMOJIMAPWEB.put("大哭",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_daku_c4cf035.png");
		EMOJIMAPWEB.put("生病",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shengbin_2f18be2.png");
		EMOJIMAPWEB.put("难过",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_naguo_6ac90c6.png");
		EMOJIMAPWEB.put("挤笑",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jixiao_45_9cbbeb0.png");
		EMOJIMAPWEB.put("流泪",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_liulei_e82b024.png");
		EMOJIMAPWEB.put("惊讶",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jingya_f4d3f19.png");
		EMOJIMAPWEB.put("期待",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_qidai_230ebe0.png");
		EMOJIMAPWEB.put("冷汗",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lenghan_e14a9f1.png");
		EMOJIMAPWEB.put("惊悚",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jingsun_5c05f23.png");
		EMOJIMAPWEB.put("拒绝",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_jujue_e3c96db.png");
		EMOJIMAPWEB.put("脸红",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lianhong_595f92f.png");
		EMOJIMAPWEB.put("睡觉",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_shuijiao_b83bb83.png");
		EMOJIMAPWEB.put("冷静",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_lengjing_4a97155.png");
		EMOJIMAPWEB.put("口罩",
				"http://sts0.mofang.com/statics/v4/face/img/emoji/emoji_kouzhao_02c0354.png");
	}
	
	private static void initEmojiMapApp() {
		EMOJIMAPAPP
				.put("大哭",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_daku_32227fe.png");
		EMOJIMAPAPP
				.put("很衰",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_shuai_de5c842.png");
		EMOJIMAPAPP
				.put("疑问",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_yiwen_8e81026.png");
		EMOJIMAPAPP
				.put("搞怪",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_gaoguai_087eaed.png");
		EMOJIMAPAPP
				.put("亲亲",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_qinqin_2ed0b75.png");
		EMOJIMAPAPP
				.put("晕了",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_yun_972fa19.png");
		EMOJIMAPAPP
				.put("可爱",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_keai_cf91e20.png");
		EMOJIMAPAPP
				.put("高兴",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_le_ea2273b.png");
		EMOJIMAPAPP
				.put("尴尬",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_ganga_6b2b055.png");
		EMOJIMAPAPP
				.put("受伤",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_shoushang_e0a1a65.png");
		EMOJIMAPAPP
				.put("恶寒",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_ehan_e0bf4c9.png");
		EMOJIMAPAPP
				.put("愤怒",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_nu_971702b.png");
		EMOJIMAPAPP
				.put("惊恐",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_jingkong_951320d.png");
		EMOJIMAPAPP
				.put("叹气",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_tanqi_82a4890.png");
		EMOJIMAPAPP
				.put("色心",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_taoxinyan_c0f4963.png");
		EMOJIMAPAPP
				.put("盛怒",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_shengnu_da3fd6f.png");
		EMOJIMAPAPP
				.put("奋斗",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_fendou_b8dedba.png");
		EMOJIMAPAPP
				.put("吐血",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_tuxue_45b4e9a.png");
		EMOJIMAPAPP
				.put("不屑",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_buxie_6266d10.png");
		EMOJIMAPAPP
				.put("呕吐",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_outu_e650ae3.png");
		EMOJIMAPAPP
				.put("很囧",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_jiong_984f134.png");
		EMOJIMAPAPP
				.put("很困",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_henkun_a678229.png");
		EMOJIMAPAPP
				.put("鄙视",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_bishi_5ecb3bd.png");
		EMOJIMAPAPP
				.put("财迷",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_caimi_4cf33cd.png");
		EMOJIMAPAPP
				.put("送花",
						"http://sts0.mofang.com/statics/v4/face2/img/emoji_demon/emoji_demon_songhua_7541e6c.png");
	}
	
	public static Map<String, String> getEmojiMapWeb() {
		return EMOJIMAPWEB;
	}
	
	public static Map<String, String> getEmojiMapApp() {
		return EMOJIMAPAPP;
	}
}
