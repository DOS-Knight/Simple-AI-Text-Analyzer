package com.example.myapplication;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SentimentAnalyzer {

    private static final HashMap<String, Integer> happyWords = new HashMap<>();
    private static final HashMap<String, Integer> sadWords = new HashMap<>();
    private static final HashMap<String, Integer> angryWords = new HashMap<>();
    private static final HashMap<String, Integer> anxiousWords = new HashMap<>();

    static {

        // خوشحال
        // فارسی
        happyWords.put("خوشحال", 3);
        happyWords.put("خوشحالم", 4);
        happyWords.put("شاد", 3);
        happyWords.put("شادم", 4);
        happyWords.put("سرحال", 3);
        happyWords.put("عالی", 3);
        happyWords.put("فوق العاده", 4);
        happyWords.put("بینظیر", 4);
        happyWords.put("محشر", 4);
        happyWords.put("راضی", 3);
        happyWords.put("راضیم", 4);
        happyWords.put("حال خوب", 3);
        happyWords.put("حالم خوبه", 4);
        happyWords.put("حالم عالیه", 5);
        happyWords.put("خیلی خوب", 4);
        happyWords.put("خیلی خوشحالم", 5);
        happyWords.put("ذوق زده", 4);
        happyWords.put("موفق شدم", 5);
        happyWords.put("موفقیت", 4);
        happyWords.put("پیروز", 4);
        happyWords.put("پیروزی", 4);
        happyWords.put("دوست دارم", 3);
        happyWords.put("لذت بردم", 4);
        happyWords.put("لذت بخش", 4);
        happyWords.put("امیدوار", 3);
        happyWords.put("امیدوارم", 3);
        happyWords.put("خوشبخت", 4);
        happyWords.put("لبخند", 3);
        happyWords.put("خنده", 3);
        happyWords.put("شاداب", 3);
        happyWords.put("آرامش", 3);
        happyWords.put("انرژی دارم", 3);
        happyWords.put("پر انرژی", 4);
        happyWords.put("مثبت", 3);

// English
        happyWords.put("happy", 3);
        happyWords.put("very happy", 5);
        happyWords.put("joy", 4);
        happyWords.put("joyful", 4);
        happyWords.put("glad", 3);
        happyWords.put("excited", 4);
        happyWords.put("amazing", 5);
        happyWords.put("awesome", 5);
        happyWords.put("wonderful", 5);
        happyWords.put("excellent", 5);
        happyWords.put("fantastic", 5);
        happyWords.put("great", 4);
        happyWords.put("good", 3);
        happyWords.put("very good", 4);
        happyWords.put("perfect", 5);
        happyWords.put("incredible", 5);
        happyWords.put("beautiful", 4);
        happyWords.put("brilliant", 4);
        happyWords.put("outstanding", 5);
        happyWords.put("successful", 4);
        happyWords.put("success", 4);
        happyWords.put("win", 4);
        happyWords.put("winner", 4);
        happyWords.put("victory", 4);
        happyWords.put("enjoy", 3);
        happyWords.put("enjoyed", 4);
        happyWords.put("enjoying", 4);
        happyWords.put("love", 4);
        happyWords.put("lovely", 4);
        happyWords.put("best", 5);
        happyWords.put("nice", 3);
        happyWords.put("pleasant", 3);
        happyWords.put("positive", 3);
        happyWords.put("hopeful", 3);
        happyWords.put("good feeling", 4);
        happyWords.put("feeling good", 4);
        happyWords.put("feeling great", 5);
        happyWords.put("smile", 3);
        happyWords.put("laugh", 3);
        happyWords.put("thankful", 3);
        happyWords.put("grateful", 4);
        happyWords.put("blessed", 4);
        happyWords.put("cheerful", 4);
        happyWords.put("delighted", 5);
        happyWords.put("optimistic", 4);
        happyWords.put("satisfied", 4);
        happyWords.put("content", 3);
        happyWords.put("peaceful", 3);
        happyWords.put("calm", 3);
        happyWords.put("energetic", 4);
        happyWords.put("motivated", 4);
        happyWords.put("inspired", 4);
        happyWords.put("proud", 4);
        happyWords.put("confident", 4);
        happyWords.put("thrilled", 5);
        happyWords.put("pleased", 4);


        // غمگین
        sadWords.put("غمگین", 3);
        sadWords.put("ناراحت", 2);
        sadWords.put("افسرده", 4);
        sadWords.put("دلگیر", 2);
        sadWords.put("تنها", 2);
        sadWords.put("بیکس", 3);
        sadWords.put("بی کس", 3);
        sadWords.put("گریه", 3);
        sadWords.put("گریه کردم", 4);
        sadWords.put("گریه میکنم", 4);
        sadWords.put("گریه می‌کنم", 4);
        sadWords.put("اشک", 3);
        sadWords.put("اشک ریختم", 4);
        sadWords.put("غم", 3);
        sadWords.put("غمگینم", 4);
        sadWords.put("خیلی غمگین", 5);
        sadWords.put("خیلی ناراحتم", 5);
        sadWords.put("داغون", 4);
        sadWords.put("شکسته", 3);
        sadWords.put("دلشکسته", 5);
        sadWords.put("شکست خوردم", 3);
        sadWords.put("تنهایی", 3);
        sadWords.put("احساس تنهایی", 4);
        sadWords.put("بی ارزش", 4);
        sadWords.put("بی‌ارزش", 4);
        sadWords.put("ناامید", 4);
        sadWords.put("ناامیدی", 4);
        sadWords.put("امید ندارم", 4);
        sadWords.put("حالم بده", 3);
        sadWords.put("حال خوبی ندارم", 4);
        sadWords.put("خسته ام", 2);
        sadWords.put("خسته‌ام", 2);
        sadWords.put("خسته شدم", 2);
        sadWords.put("بی حوصله", 3);
        sadWords.put("بی‌حوصله", 3);
        sadWords.put("دلخور", 2);
        sadWords.put("رنج میکشم", 4);
        sadWords.put("رنج می‌کشم", 4);
        sadWords.put("بدبختم", 4);
        sadWords.put("بدبخت", 3);
        sadWords.put("از دست دادم", 4);
        sadWords.put("فقدان", 4);
        sadWords.put("سوگوار", 5);
        sadWords.put("سوگواری", 5);
        sadWords.put("خودکشی", 6);

// English

        sadWords.put("sad", 3);
        sadWords.put("very sad", 5);
        sadWords.put("sadness", 4);
        sadWords.put("alone", 3);
        sadWords.put("lonely", 4);
        sadWords.put("depressed", 5);
        sadWords.put("depression", 5);
        sadWords.put("unhappy", 3);
        sadWords.put("upset", 3);
        sadWords.put("heartbroken", 5);
        sadWords.put("broken heart", 5);
        sadWords.put("cry", 3);
        sadWords.put("crying", 4);
        sadWords.put("tears", 3);
        sadWords.put("miserable", 5);
        sadWords.put("hopeless", 5);
        sadWords.put("lost", 3);
        sadWords.put("hurt", 3);
        sadWords.put("pain", 3);
        sadWords.put("suffering", 4);
        sadWords.put("empty", 3);
        sadWords.put("worthless", 5);
        sadWords.put("tired", 2);
        sadWords.put("exhausted", 3);
        sadWords.put("disappointed", 3);
        sadWords.put("failure", 3);
        sadWords.put("i feel bad", 3);
        sadWords.put("i am sad", 4);
        sadWords.put("i am lonely", 4);
        sadWords.put("i miss you", 3);
        sadWords.put("grief", 5);
        sadWords.put("mourning", 5);
        sadWords.put("tragic", 4);
        sadWords.put("regret", 3);
        sadWords.put("regretful", 3);


        // عصبانی
        // فارسی
        angryWords.put("عصبانی", 3);
        angryWords.put("عصبیم", 3);
        angryWords.put("عصبانی هستم", 3);
        angryWords.put("عصبانی شدم", 3);
        angryWords.put("خشمگین", 4);
        angryWords.put("خشمگینم", 4);
        angryWords.put("خشم", 4);
        angryWords.put("کلافه", 2);
        angryWords.put("کلافه شدم", 3);
        angryWords.put("حرص", 2);
        angryWords.put("حرصم گرفته", 3);
        angryWords.put("اعصاب خرد", 4);
        angryWords.put("اعصابم خورده", 4);
        angryWords.put("اعصابم داغونه", 4);
        angryWords.put("اعصابم خراب شده", 4);
        angryWords.put("اعصاب ندارم", 4);
        angryWords.put("اعصابمو خورد کرد", 4);
        angryWords.put("اعصابم رو خورد کرد", 4);
        angryWords.put("کفرم دراومده", 5);
        angryWords.put("کفرم درآمده", 5);
        angryWords.put("از کوره در رفتم", 5);
        angryWords.put("جوش آوردم", 4);
        angryWords.put("جوش میارم", 4);
        angryWords.put("متنفرم", 4);
        angryWords.put("نفرت", 4);
        angryWords.put("نفرت دارم", 4);
        angryWords.put("بیزارم", 4);
        angryWords.put("لعنت", 3);
        angryWords.put("لعنتی", 3);
        angryWords.put("مزخرف", 4);
        angryWords.put("افتضاح", 3);
        angryWords.put("چرند", 3);
        angryWords.put("چرت", 3);
        angryWords.put("احمق", 4);
        angryWords.put("نادان", 3);
        angryWords.put("بی عرضه", 4);
        angryWords.put("بی‌عرضه", 4);
        angryWords.put("بی شعور", 4);
        angryWords.put("بی‌شعور", 4);
        angryWords.put("عصبانی کننده", 3);
        angryWords.put("غیرقابل تحمل", 4);
        angryWords.put("تحمل ندارم", 3);
        angryWords.put("خسته شدم", 2);
        angryWords.put("حالم به هم میخوره", 4);
        angryWords.put("حالم به هم می‌خوره", 4);
        angryWords.put("وحشتناک بد", 4);
        angryWords.put("بدترین", 4);
        angryWords.put("افتضاحه", 4);
        angryWords.put("رو اعصابه", 4);
        angryWords.put("رو مخه", 4);
        angryWords.put("عصبانی کننده است", 3);
        angryWords.put("ناراضی", 2);

// English
        angryWords.put("angry", 3);
        angryWords.put("very angry", 5);
        angryWords.put("mad", 3);
        angryWords.put("furious", 5);
        angryWords.put("rage", 5);
        angryWords.put("raging", 5);
        angryWords.put("annoyed", 2);
        angryWords.put("annoying", 3);
        angryWords.put("irritated", 3);
        angryWords.put("frustrated", 3);
        angryWords.put("frustration", 3);
        angryWords.put("hate", 4);
        angryWords.put("i hate", 5);
        angryWords.put("i hate this", 5);
        angryWords.put("hateful", 4);
        angryWords.put("upset", 2);
        angryWords.put("fed up", 4);
        angryWords.put("pissed", 4);
        angryWords.put("pissed off", 5);
        angryWords.put("sick of this", 4);
        angryWords.put("terrible", 3);
        angryWords.put("awful", 3);
        angryWords.put("ridiculous", 3);
        angryWords.put("stupid", 4);
        angryWords.put("idiot", 4);
        angryWords.put("nonsense", 3);
        angryWords.put("garbage", 3);
        angryWords.put("trash", 3);
        angryWords.put("infuriating", 5);
        angryWords.put("enraged", 5);
        angryWords.put("annoyance", 3);
        angryWords.put("disgusted", 4);
        angryWords.put("hate it", 5);
        angryWords.put("unacceptable", 4);
        angryWords.put("unfair", 3);
        angryWords.put("outraged", 5);
        angryWords.put("anger", 4);
        angryWords.put("angry at", 4);
        angryWords.put("can't stand it", 4);
        angryWords.put("sick and tired", 4);
        angryWords.put("worst", 4);
        angryWords.put("horrible", 4);
        angryWords.put("disappointed", 2);
        angryWords.put("this sucks", 4);
        angryWords.put("useless", 3);
        angryWords.put("pathetic", 4);
        angryWords.put("worthless", 4);


        // مضطرب
        // فارسی
        anxiousWords.put("نگران", 3);
        anxiousWords.put("نگرانی", 3);
        anxiousWords.put("نگرانم", 3);
        anxiousWords.put("استرس", 4);
        anxiousWords.put("استرسی", 4);
        anxiousWords.put("استرس دارم", 4);
        anxiousWords.put("اضطراب", 4);
        anxiousWords.put("مضطرب", 4);
        anxiousWords.put("دلشوره", 3);
        anxiousWords.put("دلهره", 3);
        anxiousWords.put("دلهره دارم", 3);
        anxiousWords.put("ترس", 2);
        anxiousWords.put("میترسم", 3);
        anxiousWords.put("می‌ترسم", 3);
        anxiousWords.put("ترسیده", 3);
        anxiousWords.put("هراس", 4);
        anxiousWords.put("وحشت", 4);
        anxiousWords.put("وحشت زده", 5);
        anxiousWords.put("وحشت‌زده", 5);
        anxiousWords.put("پانیک", 5);
        anxiousWords.put("حمله پانیک", 6);
        anxiousWords.put("بیقرار", 3);
        anxiousWords.put("بی قرار", 3);
        anxiousWords.put("ناآرام", 3);
        anxiousWords.put("آشفته", 2);
        anxiousWords.put("پریشان", 2);
        anxiousWords.put("تشویش", 3);
        anxiousWords.put("دلواپس", 3);
        anxiousWords.put("دلواپسی", 3);
        anxiousWords.put("ترسناک", 2);
        anxiousWords.put("ترسیده ام", 3);
        anxiousWords.put("ترسیده‌ام", 3);
        anxiousWords.put("خوف", 3);
        anxiousWords.put("مردد", 2);
        anxiousWords.put("سردرگم", 2);
        anxiousWords.put("اعتماد به نفس ندارم", 3);
        anxiousWords.put("فشار روانی", 4);
        anxiousWords.put("فشار عصبی", 4);
        anxiousWords.put("نگران آینده", 4);
        anxiousWords.put("نگران امتحان", 4);
        anxiousWords.put("نگران نتیجه", 4);
        anxiousWords.put("نگران کار", 3);
        anxiousWords.put("نگران سلامتی", 4);
        anxiousWords.put("بی خواب", 2);
        anxiousWords.put("بیخوابی", 2);
        anxiousWords.put("خوابم نمیبره", 3);
        anxiousWords.put("خوابم نمی‌بره", 3);
        anxiousWords.put("دلشوره دارم", 3);
        anxiousWords.put("اعصابم خورده", 3);
        anxiousWords.put("اعصاب ندارم", 3);
        anxiousWords.put("نگران کننده", 3);
        anxiousWords.put("پرتنش", 3);
        anxiousWords.put("تنش", 3);
        anxiousWords.put("تنش دارم", 3);
        anxiousWords.put("استرس شدید", 5);
        anxiousWords.put("اضطراب شدید", 5);
        anxiousWords.put("وحشت شدید", 5);
        anxiousWords.put("ترس شدید", 4);

// English
        anxiousWords.put("anxious", 4);
        anxiousWords.put("anxiety", 4);
        anxiousWords.put("stress", 4);
        anxiousWords.put("stressed", 4);
        anxiousWords.put("worried", 3);
        anxiousWords.put("worry", 3);
        anxiousWords.put("fear", 2);
        anxiousWords.put("afraid", 3);
        anxiousWords.put("panic", 5);
        anxiousWords.put("panicked", 5);
        anxiousWords.put("panic attack", 6);
        anxiousWords.put("nervous", 3);
        anxiousWords.put("uneasy", 2);
        anxiousWords.put("restless", 2);
        anxiousWords.put("scared", 3);
        anxiousWords.put("frightened", 4);
        anxiousWords.put("terrified", 5);
        anxiousWords.put("concerned", 2);
        anxiousWords.put("overthinking", 3);
        anxiousWords.put("tension", 3);
        anxiousWords.put("tense", 3);
        anxiousWords.put("pressure", 3);
        anxiousWords.put("mental pressure", 4);
        anxiousWords.put("psychological pressure", 4);
        anxiousWords.put("can't sleep", 3);
        anxiousWords.put("insomnia", 3);
        anxiousWords.put("worrying", 3);
        anxiousWords.put("fearful", 3);
        anxiousWords.put("uncertain", 2);
        anxiousWords.put("insecure", 3);
        anxiousWords.put("troubled", 2);
        anxiousWords.put("disturbed", 2);
        anxiousWords.put("alarmed", 4);
        anxiousWords.put("overwhelmed", 3);
        anxiousWords.put("apprehensive", 4);
        anxiousWords.put("under pressure", 4);
        anxiousWords.put("high stress", 5);
        anxiousWords.put("extreme anxiety", 5);
        anxiousWords.put("extremely worried", 5);
        anxiousWords.put("i am worried", 3);
        anxiousWords.put("i am anxious", 4);
        anxiousWords.put("i am stressed", 4);
        anxiousWords.put("i am scared", 3);
        anxiousWords.put("i am afraid", 3);
    }


    // درصد  برای PieChart
    public static HashMap<String, Float> analyzePercent(String text) {

        text = text.toLowerCase();

        float happy = calculate(text, happyWords);
        float sad = calculate(text, sadWords);
        float angry = calculate(text, angryWords);
        float anxious = calculate(text, anxiousWords);

        float total = happy + sad + angry + anxious;

        HashMap<String, Float> result = new LinkedHashMap<>();

        if (total == 0) {
            result.put("خنثی", 100f);
            return result;
        }

        result.put("خوشحال", (happy / total) * 100);
        result.put("غمگین", (sad / total) * 100);
        result.put("عصبانی", (angry / total) * 100);
        result.put("مضطرب", (anxious / total) * 100);

        return result;
    }

    private static float calculate(String text, HashMap<String, Integer> map) {
        float score = 0;
        for (String key : map.keySet()) {
            if (text.contains(key)) {
                score += map.get(key);
            }
        }
        return score;
    }

    //  برای txtEmotion
    public static String analyze(String text) {

        HashMap<String, Float> p = analyzePercent(text);

        String best = "خنثی";
        float max = 0;

        for (String key : p.keySet()) {
            if (p.get(key) > max && !key.equals("خنثی")) {
                max = p.get(key);
                best = key;
            }
        }

        return best + " (" + (int) max + "%)";
    }
}