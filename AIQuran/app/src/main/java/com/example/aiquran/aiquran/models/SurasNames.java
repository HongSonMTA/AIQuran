package com.example.aiquran.aiquran.models;

public class SurasNames {


    public static String[] jozaNamesAr = new String[]{"الأول", "الثاني", "الثالث", "الرابع", "الخامس",
            "السادس", "السابع", "الثامن", "التاسع", "العاشر", "الحادي عشر", "الثاني عشر", "الثالث عشر",
            "الرابع عشر", "الخامس عشر", "السادس عشر", "السابع عشر", "الثامن عشر", "التاسع عشر", "العشرون",
            "الأول والعشرون", "الثاني والعشرون", "الثالث والعشرون", "الرابع والعشرون", "الخامس والعشرون",
            "السادس والعشرون", "السابع والعشرون", "الثامن والعشرون", "التاسع والعشرون", "الثلاثون"};

    public static String[] suraNamesAr = new String[]{"الفاتحة", "البقرة", "آل عمران", "النساء",
            "المائدة", "الأنعام", "الأعراف", "الأنفال", "التوبة", "يونس", "هود", "يوسف", "الرعد",
            "إبراهيم", "الحجر", "النحل", "الإسراء", "الكهف", "مريم", "طه", "الأنبياء", "الحج",
            "المؤمنون", "النور", "الفرقان", "الشعراء", "النمل", "القصص", "العنكبوت", "الروم", "لقمان",
            "السجدة", "الأحزاب", "سبأ", "فاطر", "يس", "الصافات", "ص", "الزمر", "غافر", "فصلت", "الشورى",
            "الزخرف", "الدخان", "الجاثية", "الأحقاف", "محمد", "الفتح", "الحجرات", "ق", "الذاريات", "الطور",
            "النجم", "القمر", "الرحمن", "الواقعة", "الحديد", "المجادلة", "الحشر", "الممتحنة", "الصف",
            "الجمعة", "المنافقون", "التغابن", "الطلاق", "التحريم", "الملك", "القلم", "الحاقة", "المعارج",
            "نوح", "الجن", "المزمل", "المدثر", "القيامة", "الإنسان", "المرسلات", "النبأ", "النازعات",
            "عبس", "التكوير", "الانفطار", "المطففين", "الانشقاق", "البروج", "الطارق", "الأعلى", "الغاشية",
            "الفجر", "البلد", "الشمس", "الليل", "الضحى", "الشرح", "التين", "العلق", "القدر", "البينة",
            "الزلزلة", "العاديات", "القارعة", "التكاثر", "العصر", "الهمزة", "الفيل", "قريش", "الماعون",
            "الكوثر", "الكافرون", "النصر", "المسد", "الإخلاص", "الفلق", "الناس"};

    public static String[] suraNamesEn = new String[]{"AlFatihah", "AlBaqarah ", "Al'Imran", "AnNisa'",
            "AlMa'idah", "AlAn'am", "AlA'raf", "AlAnfal", "AtTaubah", "Yunus", "Hud", "Yusuf", "ArRa'd",
            "Ibrahim", "AlHijr", "AnNahl", "AlIsra'", "AlKahf", "Maryam", "TaHa", "AlAnbiya'", "AlHajj",
            "AlMu'minun", "AnNur", "AlFurqan", "AshShu'ara'", "AnNaml", "AlQasas", "AlAnkabut", "ArRum",
            "Luqman", "AsSajdah", "AlAhzab", "Saba'", "Fatir", "YaSin", "AsSaffat", "Sad", "AzZumar",
            "Ghafir", "Fussilat", "AshShura", "AzZukhruf", "AdDukhan", "AlJathiyah", "AlAhqaf", "Muhammad",
            "AlFath", "AlHujurat", "Qaf", "AdhDhariyat", "AtTur", "AnNajm", "Qamar", "ArRahman", "AlWaqi'ah",
            "AlHadid", "AlMujadilah", "AlHashr", "AlMumtahanah", "AsSaff", "AlJumu'ah", "AlMunafiqun",
            "AtTaghabun", "AtTalaq", "AtTahrim", "AlMulk", "AlQalam", "AlHaqqah", "AlMa'arij", "Nuh",
            "AlJinn", "AlMuzzammil", "AlMuddaththir", "AlQiyamah", "AlInsan", "AlMursalat", "AnNaba'",
            "AnNazi'at", "Abasa", "AtTakwir", "AlInfitar", "AlMutaffifin", "AlInshiqaq", "AlBuruj",
            "AtTariq", "AlA'la", "AlGhashiyah", "AlFajr", "AlBalad", "AshShams", "AlLail", "AdDuha",
            "AshSharh", "AtTin", "AlAlaq", "AlQadr", "AlBayyinah", "AzZalzalah", "AlAadiyat",
            "AlQari'ah", "AtTakathur", "AlAsr", "AlHumazah", "AlFil", "Quraish", "AlMa'un", "AlKauthar",
            "AlKafirun", "AnNasr", "AlMasad", "AlIkhlas", "AlFalaq", "AnNas"};


    public String getSuraNameEn(int i) {
        return suraNamesEn[i];
    }

    public String getSurasNameAr(int i) {
        return suraNamesAr[i];
    }

    public String getJozaNameAr(int i) {
        return jozaNamesAr[i];
    }

    public  String[] getJozaNamesAr() {
        return jozaNamesAr;
    }

    public  String[] getSuraNamesAr() {
        return suraNamesAr;
    }

    public  String[] getSuraNamesEn() {
        return suraNamesEn;
    }

}
