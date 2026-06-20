package com.example.myapplication;

import java.util.ArrayList;

public class TopicAnalyzer {

    public static String analyze(String text) {

        text = text.toLowerCase();

        ArrayList<String> topics = new ArrayList<>();

        //  آموزشی
        if (
                        text.contains("امتحان") || text.contains("دانشگاه") ||
                        text.contains("درس") || text.contains("مدرسه") ||
                        text.contains("ریاضی") || text.contains("فارسی") ||
                        text.contains("علوم") || text.contains("کلاس") ||
                        text.contains("تکلیف") || text.contains("کتاب") ||
                        text.contains("استاد") || text.contains("معلم") ||
                        text.contains("یادگیری") || text.contains("تحصیل") ||
                        text.contains("exam") || text.contains("study") ||
                        text.contains("school") || text.contains("university") ||
                        text.contains("homework") || text.contains("class") ||
                        text.contains("education") || text.contains("student")
        ) {
            topics.add("📚 Education / آموزشی");
        }

        //  ورزشی
        if (
                        text.contains("فوتبال") || text.contains("ورزش") ||
                        text.contains("والیبال") || text.contains("کشتی") ||
                        text.contains("بوکس") || text.contains("جودو") ||
                        text.contains("بسکتبال") || text.contains("دویدن") ||
                        text.contains("تمرین") || text.contains("باشگاه") ||
                        text.contains("fitness") || text.contains("gym") ||
                        text.contains("football") || text.contains("soccer") ||
                        text.contains("basketball") || text.contains("volleyball") ||
                        text.contains("sport") || text.contains("training")
        ) {
            topics.add("⚽ Sports / ورزشی");
        }

        //  فناوری
        if (
                        text.contains("کامپیوتر") || text.contains("موبایل") ||
                        text.contains("اینترنت") || text.contains("برنامه نویسی") ||
                        text.contains("هوش مصنوعی") || text.contains("کد") ||
                        text.contains("نرم افزار") || text.contains("سیستم") ||
                        text.contains("اپلیکیشن") || text.contains("برنامه") ||
                        text.contains("technology") || text.contains("computer") ||
                        text.contains("software") || text.contains("hardware") ||
                        text.contains("android") || text.contains("ai") ||
                        text.contains("code") || text.contains("app")
        ) {
            topics.add("💻 Technology / فناوری");
        }

        //  اقتصادی
        if (
                         text.contains("پول") || text.contains("اقتصاد") ||
                        text.contains("بازار") || text.contains("خرید") ||
                        text.contains("فروش") || text.contains("قیمت") ||
                        text.contains("سرمایه") || text.contains("ارزش") ||
                        text.contains("درآمد") || text.contains("هزینه") ||
                        text.contains("money") || text.contains("market") ||
                        text.contains("price") || text.contains("buy") ||
                        text.contains("sell") || text.contains("income") ||
                        text.contains("cost") || text.contains("finance")
        ) {
            topics.add("💰 Economy / اقتصادی");
        }

        //  پزشکی
        if (
                        text.contains("دکتر") || text.contains("بیمار") ||
                        text.contains("بیماری") || text.contains("دارو") ||
                        text.contains("درمان") || text.contains("سلامت") ||
                        text.contains("بیمارستان") || text.contains("تب") ||
                        text.contains("درد") || text.contains("پزشک") ||
                        text.contains("doctor") || text.contains("hospital") ||
                        text.contains("medicine") || text.contains("health") ||
                        text.contains("pain") || text.contains("treatment")
        ) {
            topics.add("🏥 Health / پزشکی");
        }//  سرگرمی
        if (
                        text.contains("فیلم") || text.contains("سریال") ||
                        text.contains("موزیک") || text.contains("آهنگ") ||
                        text.contains("بازی") || text.contains("سرگرمی") ||
                        text.contains("تفریح") || text.contains("کارتون") ||
                        text.contains("movie") || text.contains("music") ||
                        text.contains("game") || text.contains("entertainment") ||
                        text.contains("fun") || text.contains("series")
        ) {
            topics.add("🎮 Entertainment / سرگرمی");
        }

        //  SOCIAL
        if (
                          text.contains("دوست") || text.contains("خانواده") ||
                        text.contains("رابطه") || text.contains("عشق") ||
                        text.contains("تنهایی") || text.contains("social") ||
                        text.contains("friend") || text.contains("family") ||
                        text.contains("relationship") || text.contains("love")
        ) {
            topics.add("🌍 Social / روابط اجتماعی");
        }

        // اگر چیزی پیدا نشد
        if (topics.isEmpty()) {
            return "❓ Unknown / نامشخص";
        }

        return String.join(" + ", topics);
    }
}