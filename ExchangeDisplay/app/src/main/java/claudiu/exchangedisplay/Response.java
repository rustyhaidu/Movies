package claudiu.exchangedisplay;

/**
 * Created by Claudiu on 9/6/2015.
 */
public class Response {


    /**
     * disclaimer : Exchange rates are provided for informational purposes only, and do not constitute financial advice of any kind. Although every attempt is made to ensure quality, NO guarantees are given whatsoever of accuracy, validity, availability, or fitness for any purpose - please use at your own risk. All usage is subject to your acceptance of the Terms and Conditions of Service, available at: https://openexchangerates.org/terms/
     * license : Data sourced from various providers with public-facing APIs; copyright may apply; resale is prohibited; no warranties given of any kind. Bitcoin data provided by http://coindesk.com. All usage is subject to your acceptance of the License Agreement available at: https://openexchangerates.org/license/
     * timestamp : 1441569609
     * base : USD
     * rates : {"AED":3.67331,"AFN":62.8,"ALL":125.4949,"AMD":485.015003,"ANG":1.789,"AOA":125.717334,"ARS":9.3334,"AUD":1.446908,"AWG":1.793333,"AZN":1.049938,"BAM":1.755081,"BBD":2,"BDT":77.85839,"BGN":1.75428,"BHD":0.377646,"BIF":1553.575,"BMD":1,"BND":1.4218,"BOB":6.90428,"BRL":3.843894,"BSD":1,"BTC":0.0041787135,"BTN":66.547249,"BWP":10.490788,"BYR":17682,"BZD":1.99505,"CAD":1.327484,"CDF":926.5,"CHF":0.971752,"CLF":0.024598,"CLP":692.735001,"CNY":6.35695,"COP":3120.983333,"CRC":536.183998,"CUC":1,"CUP":1.000088,"CVE":98.851139055,"CZK":24.23433,"DJF":177.72,"DKK":6.69015,"DOP":45.06546,"DZD":106.03782,"EEK":14.026325,"EGP":7.82673,"ERN":15.14,"ETB":20.85656,"EUR":0.896487,"FJD":2.188133,"FKP":0.658987,"GBP":0.658987,"GEL":2.37295,"GGP":0.658987,"GHS":3.78226,"GIP":0.658987,"GMD":39.8043,"GNF":7250.075049,"GTQ":7.73492,"GYD":205.963336,"HKD":7.750283,"HNL":21.833,"HRK":6.77911,"HTG":52.89705,"HUF":281.486401,"IDR":14158.733333,"ILS":3.921849,"IMP":0.658987,"INR":66.656649,"IQD":1142.649951,"IRR":29956,"ISK":129.559,"JEP":0.658987,"JMD":117.816001,"JOD":0.709362,"JPY":118.9796,"KES":105.627899,"KGS":65.362701,"KHR":4102.725,"KMF":442.068582,"KPW":899.91,"KRW":1199.011649,"KWD":0.302382,"KYD":0.82665,"KZT":240.439991,"LAK":8176.425098,"LBP":1506.55,"LKR":137.981999,"LRD":88.49115,"LSL":13.867663,"LTL":3.044092,"LVL":0.626875,"LYD":1.364225,"MAD":9.74667,"MDL":19.37088,"MGA":3264.050016,"MKD":55.48318,"MMK":1081.1081,"MNT":1989.583333,"MOP":7.98356,"MRO":319.6325,"MTL":0.683602,"MUR":35.416875,"MVR":15.303333,"MWK":562.219995,"MXN":16.9344,"MYR":4.301165,"MZN":41.7775,"NAD":13.81773,"NGN":199.042,"NIO":27.26768,"NOK":8.305071,"NPR":106.341101,"NZD":1.591952,"OMR":0.385181,"PAB":1,"PEN":3.21128,"PGK":2.806375,"PHP":46.90784,"PKR":104.22876,"PLN":3.788191,"PYG":5383.691634,"QAR":3.64065,"RON":3.97053,"RSD":107.81904,"RUB":68.46396,"RWF":710.990005,"SAR":3.750804,"SBD":7.950423,"SCR":13.05185,"SDG":6.085525,"SEK":8.431752,"SGD":1.423835,"SHP":0.658987,"SLL":3745.3745,"SOS":662.820003,"SRD":3.2825,"STD":22003.25,"SVC":8.7803,"SYP":188.871003,"SZL":13.81943,"THB":35.97904,"TJS":6.31995,"TMT":3.5021,"TND":1.96823,"TOP":2.263774,"TRY":3.008178,"TTD":6.34938,"TWD":32.74031,"TZS":2147.016683,"UAH":22.05432,"UGX":3671.016667,"USD":1,"UYU":28.65646,"UZS":2598.29003,"VEF":6.32042,"VND":22473,"VUV":109.640001,"WST":2.585918,"XAF":589.229975,"XAG":0.0686935,"XAU":8.9E-4,"XCD":2.70102,"XDR":0.71342,"XOF":589.972115,"XPD":0.001734,"XPF":107.093588,"XPT":0.001008,"YER":215.018,"ZAR":13.86085,"ZMK":5253.075255,"ZMW":10.038467,"ZWL":322.387247}
     */

    private String disclaimer;
    private String license;
    private int timestamp;
    private String base;
    private RatesEntity rates;

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setRates(RatesEntity rates) {
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public RatesEntity getRates() {
        return rates;
    }

    public static class RatesEntity {
        /**
         * AED : 3.67331
         * AFN : 62.8
         * ALL : 125.4949
         * AMD : 485.015003
         * ANG : 1.789
         * AOA : 125.717334
         * ARS : 9.3334
         * AUD : 1.446908
         * AWG : 1.793333
         * AZN : 1.049938
         * BAM : 1.755081
         * BBD : 2
         * BDT : 77.85839
         * BGN : 1.75428
         * BHD : 0.377646
         * BIF : 1553.575
         * BMD : 1
         * BND : 1.4218
         * BOB : 6.90428
         * BRL : 3.843894
         * BSD : 1
         * BTC : 0.0041787135
         * BTN : 66.547249
         * BWP : 10.490788
         * BYR : 17682
         * BZD : 1.99505
         * CAD : 1.327484
         * CDF : 926.5
         * CHF : 0.971752
         * CLF : 0.024598
         * CLP : 692.735001
         * CNY : 6.35695
         * COP : 3120.983333
         * CRC : 536.183998
         * CUC : 1
         * CUP : 1.000088
         * CVE : 98.851139055
         * CZK : 24.23433
         * DJF : 177.72
         * DKK : 6.69015
         * DOP : 45.06546
         * DZD : 106.03782
         * EEK : 14.026325
         * EGP : 7.82673
         * ERN : 15.14
         * ETB : 20.85656
         * EUR : 0.896487
         * FJD : 2.188133
         * FKP : 0.658987
         * GBP : 0.658987
         * GEL : 2.37295
         * GGP : 0.658987
         * GHS : 3.78226
         * GIP : 0.658987
         * GMD : 39.8043
         * GNF : 7250.075049
         * GTQ : 7.73492
         * GYD : 205.963336
         * HKD : 7.750283
         * HNL : 21.833
         * HRK : 6.77911
         * HTG : 52.89705
         * HUF : 281.486401
         * IDR : 14158.733333
         * ILS : 3.921849
         * IMP : 0.658987
         * INR : 66.656649
         * IQD : 1142.649951
         * IRR : 29956
         * ISK : 129.559
         * JEP : 0.658987
         * JMD : 117.816001
         * JOD : 0.709362
         * JPY : 118.9796
         * KES : 105.627899
         * KGS : 65.362701
         * KHR : 4102.725
         * KMF : 442.068582
         * KPW : 899.91
         * KRW : 1199.011649
         * KWD : 0.302382
         * KYD : 0.82665
         * KZT : 240.439991
         * LAK : 8176.425098
         * LBP : 1506.55
         * LKR : 137.981999
         * LRD : 88.49115
         * LSL : 13.867663
         * LTL : 3.044092
         * LVL : 0.626875
         * LYD : 1.364225
         * MAD : 9.74667
         * MDL : 19.37088
         * MGA : 3264.050016
         * MKD : 55.48318
         * MMK : 1081.1081
         * MNT : 1989.583333
         * MOP : 7.98356
         * MRO : 319.6325
         * MTL : 0.683602
         * MUR : 35.416875
         * MVR : 15.303333
         * MWK : 562.219995
         * MXN : 16.9344
         * MYR : 4.301165
         * MZN : 41.7775
         * NAD : 13.81773
         * NGN : 199.042
         * NIO : 27.26768
         * NOK : 8.305071
         * NPR : 106.341101
         * NZD : 1.591952
         * OMR : 0.385181
         * PAB : 1
         * PEN : 3.21128
         * PGK : 2.806375
         * PHP : 46.90784
         * PKR : 104.22876
         * PLN : 3.788191
         * PYG : 5383.691634
         * QAR : 3.64065
         * RON : 3.97053
         * RSD : 107.81904
         * RUB : 68.46396
         * RWF : 710.990005
         * SAR : 3.750804
         * SBD : 7.950423
         * SCR : 13.05185
         * SDG : 6.085525
         * SEK : 8.431752
         * SGD : 1.423835
         * SHP : 0.658987
         * SLL : 3745.3745
         * SOS : 662.820003
         * SRD : 3.2825
         * STD : 22003.25
         * SVC : 8.7803
         * SYP : 188.871003
         * SZL : 13.81943
         * THB : 35.97904
         * TJS : 6.31995
         * TMT : 3.5021
         * TND : 1.96823
         * TOP : 2.263774
         * TRY : 3.008178
         * TTD : 6.34938
         * TWD : 32.74031
         * TZS : 2147.016683
         * UAH : 22.05432
         * UGX : 3671.016667
         * USD : 1
         * UYU : 28.65646
         * UZS : 2598.29003
         * VEF : 6.32042
         * VND : 22473
         * VUV : 109.640001
         * WST : 2.585918
         * XAF : 589.229975
         * XAG : 0.0686935
         * XAU : 8.9E-4
         * XCD : 2.70102
         * XDR : 0.71342
         * XOF : 589.972115
         * XPD : 0.001734
         * XPF : 107.093588
         * XPT : 0.001008
         * YER : 215.018
         * ZAR : 13.86085
         * ZMK : 5253.075255
         * ZMW : 10.038467
         * ZWL : 322.387247
         */

        private double AED;
        private double AFN;
        private double ALL;
        private double AMD;
        private double ANG;
        private double AOA;
        private double ARS;
        private double AUD;
        private double AWG;
        private double AZN;
        private double BAM;
        private int BBD;
        private double BDT;
        private double BGN;
        private double BHD;
        private double BIF;
        private int BMD;
        private double BND;
        private double BOB;
        private double BRL;
        private int BSD;
        private double BTC;
        private double BTN;
        private double BWP;
        private int BYR;
        private double BZD;
        private double CAD;
        private double CDF;
        private double CHF;
        private double CLF;
        private double CLP;
        private double CNY;
        private double COP;
        private double CRC;
        private int CUC;
        private double CUP;
        private double CVE;
        private double CZK;
        private double DJF;
        private double DKK;
        private double DOP;
        private double DZD;
        private double EEK;
        private double EGP;
        private double ERN;
        private double ETB;
        private double EUR;
        private double FJD;
        private double FKP;
        private double GBP;
        private double GEL;
        private double GGP;
        private double GHS;
        private double GIP;
        private double GMD;
        private double GNF;
        private double GTQ;
        private double GYD;
        private double HKD;
        private double HNL;
        private double HRK;
        private double HTG;
        private double HUF;
        private double IDR;
        private double ILS;
        private double IMP;
        private double INR;
        private double IQD;
        private int IRR;
        private double ISK;
        private double JEP;
        private double JMD;
        private double JOD;
        private double JPY;
        private double KES;
        private double KGS;
        private double KHR;
        private double KMF;
        private double KPW;
        private double KRW;
        private double KWD;
        private double KYD;
        private double KZT;
        private double LAK;
        private double LBP;
        private double LKR;
        private double LRD;
        private double LSL;
        private double LTL;
        private double LVL;
        private double LYD;
        private double MAD;
        private double MDL;
        private double MGA;
        private double MKD;
        private double MMK;
        private double MNT;
        private double MOP;
        private double MRO;
        private double MTL;
        private double MUR;
        private double MVR;
        private double MWK;
        private double MXN;
        private double MYR;
        private double MZN;
        private double NAD;
        private double NGN;
        private double NIO;
        private double NOK;
        private double NPR;
        private double NZD;
        private double OMR;
        private int PAB;
        private double PEN;
        private double PGK;
        private double PHP;
        private double PKR;
        private double PLN;
        private double PYG;
        private double QAR;
        private double RON;
        private double RSD;
        private double RUB;
        private double RWF;
        private double SAR;
        private double SBD;
        private double SCR;
        private double SDG;
        private double SEK;
        private double SGD;
        private double SHP;
        private double SLL;
        private double SOS;
        private double SRD;
        private double STD;
        private double SVC;
        private double SYP;
        private double SZL;
        private double THB;
        private double TJS;
        private double TMT;
        private double TND;
        private double TOP;
        private double TRY;
        private double TTD;
        private double TWD;
        private double TZS;
        private double UAH;
        private double UGX;
        private int USD;
        private double UYU;
        private double UZS;
        private double VEF;
        private int VND;
        private double VUV;
        private double WST;
        private double XAF;
        private double XAG;
        private double XAU;
        private double XCD;
        private double XDR;
        private double XOF;
        private double XPD;
        private double XPF;
        private double XPT;
        private double YER;
        private double ZAR;
        private double ZMK;
        private double ZMW;
        private double ZWL;

        public void setAED(double AED) {
            this.AED = AED;
        }

        public void setAFN(double AFN) {
            this.AFN = AFN;
        }

        public void setALL(double ALL) {
            this.ALL = ALL;
        }

        public void setAMD(double AMD) {
            this.AMD = AMD;
        }

        public void setANG(double ANG) {
            this.ANG = ANG;
        }

        public void setAOA(double AOA) {
            this.AOA = AOA;
        }

        public void setARS(double ARS) {
            this.ARS = ARS;
        }

        public void setAUD(double AUD) {
            this.AUD = AUD;
        }

        public void setAWG(double AWG) {
            this.AWG = AWG;
        }

        public void setAZN(double AZN) {
            this.AZN = AZN;
        }

        public void setBAM(double BAM) {
            this.BAM = BAM;
        }

        public void setBBD(int BBD) {
            this.BBD = BBD;
        }

        public void setBDT(double BDT) {
            this.BDT = BDT;
        }

        public void setBGN(double BGN) {
            this.BGN = BGN;
        }

        public void setBHD(double BHD) {
            this.BHD = BHD;
        }

        public void setBIF(double BIF) {
            this.BIF = BIF;
        }

        public void setBMD(int BMD) {
            this.BMD = BMD;
        }

        public void setBND(double BND) {
            this.BND = BND;
        }

        public void setBOB(double BOB) {
            this.BOB = BOB;
        }

        public void setBRL(double BRL) {
            this.BRL = BRL;
        }

        public void setBSD(int BSD) {
            this.BSD = BSD;
        }

        public void setBTC(double BTC) {
            this.BTC = BTC;
        }

        public void setBTN(double BTN) {
            this.BTN = BTN;
        }

        public void setBWP(double BWP) {
            this.BWP = BWP;
        }

        public void setBYR(int BYR) {
            this.BYR = BYR;
        }

        public void setBZD(double BZD) {
            this.BZD = BZD;
        }

        public void setCAD(double CAD) {
            this.CAD = CAD;
        }

        public void setCDF(double CDF) {
            this.CDF = CDF;
        }

        public void setCHF(double CHF) {
            this.CHF = CHF;
        }

        public void setCLF(double CLF) {
            this.CLF = CLF;
        }

        public void setCLP(double CLP) {
            this.CLP = CLP;
        }

        public void setCNY(double CNY) {
            this.CNY = CNY;
        }

        public void setCOP(double COP) {
            this.COP = COP;
        }

        public void setCRC(double CRC) {
            this.CRC = CRC;
        }

        public void setCUC(int CUC) {
            this.CUC = CUC;
        }

        public void setCUP(double CUP) {
            this.CUP = CUP;
        }

        public void setCVE(double CVE) {
            this.CVE = CVE;
        }

        public void setCZK(double CZK) {
            this.CZK = CZK;
        }

        public void setDJF(double DJF) {
            this.DJF = DJF;
        }

        public void setDKK(double DKK) {
            this.DKK = DKK;
        }

        public void setDOP(double DOP) {
            this.DOP = DOP;
        }

        public void setDZD(double DZD) {
            this.DZD = DZD;
        }

        public void setEEK(double EEK) {
            this.EEK = EEK;
        }

        public void setEGP(double EGP) {
            this.EGP = EGP;
        }

        public void setERN(double ERN) {
            this.ERN = ERN;
        }

        public void setETB(double ETB) {
            this.ETB = ETB;
        }

        public void setEUR(double EUR) {
            this.EUR = EUR;
        }

        public void setFJD(double FJD) {
            this.FJD = FJD;
        }

        public void setFKP(double FKP) {
            this.FKP = FKP;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }

        public void setGEL(double GEL) {
            this.GEL = GEL;
        }

        public void setGGP(double GGP) {
            this.GGP = GGP;
        }

        public void setGHS(double GHS) {
            this.GHS = GHS;
        }

        public void setGIP(double GIP) {
            this.GIP = GIP;
        }

        public void setGMD(double GMD) {
            this.GMD = GMD;
        }

        public void setGNF(double GNF) {
            this.GNF = GNF;
        }

        public void setGTQ(double GTQ) {
            this.GTQ = GTQ;
        }

        public void setGYD(double GYD) {
            this.GYD = GYD;
        }

        public void setHKD(double HKD) {
            this.HKD = HKD;
        }

        public void setHNL(double HNL) {
            this.HNL = HNL;
        }

        public void setHRK(double HRK) {
            this.HRK = HRK;
        }

        public void setHTG(double HTG) {
            this.HTG = HTG;
        }

        public void setHUF(double HUF) {
            this.HUF = HUF;
        }

        public void setIDR(double IDR) {
            this.IDR = IDR;
        }

        public void setILS(double ILS) {
            this.ILS = ILS;
        }

        public void setIMP(double IMP) {
            this.IMP = IMP;
        }

        public void setINR(double INR) {
            this.INR = INR;
        }

        public void setIQD(double IQD) {
            this.IQD = IQD;
        }

        public void setIRR(int IRR) {
            this.IRR = IRR;
        }

        public void setISK(double ISK) {
            this.ISK = ISK;
        }

        public void setJEP(double JEP) {
            this.JEP = JEP;
        }

        public void setJMD(double JMD) {
            this.JMD = JMD;
        }

        public void setJOD(double JOD) {
            this.JOD = JOD;
        }

        public void setJPY(double JPY) {
            this.JPY = JPY;
        }

        public void setKES(double KES) {
            this.KES = KES;
        }

        public void setKGS(double KGS) {
            this.KGS = KGS;
        }

        public void setKHR(double KHR) {
            this.KHR = KHR;
        }

        public void setKMF(double KMF) {
            this.KMF = KMF;
        }

        public void setKPW(double KPW) {
            this.KPW = KPW;
        }

        public void setKRW(double KRW) {
            this.KRW = KRW;
        }

        public void setKWD(double KWD) {
            this.KWD = KWD;
        }

        public void setKYD(double KYD) {
            this.KYD = KYD;
        }

        public void setKZT(double KZT) {
            this.KZT = KZT;
        }

        public void setLAK(double LAK) {
            this.LAK = LAK;
        }

        public void setLBP(double LBP) {
            this.LBP = LBP;
        }

        public void setLKR(double LKR) {
            this.LKR = LKR;
        }

        public void setLRD(double LRD) {
            this.LRD = LRD;
        }

        public void setLSL(double LSL) {
            this.LSL = LSL;
        }

        public void setLTL(double LTL) {
            this.LTL = LTL;
        }

        public void setLVL(double LVL) {
            this.LVL = LVL;
        }

        public void setLYD(double LYD) {
            this.LYD = LYD;
        }

        public void setMAD(double MAD) {
            this.MAD = MAD;
        }

        public void setMDL(double MDL) {
            this.MDL = MDL;
        }

        public void setMGA(double MGA) {
            this.MGA = MGA;
        }

        public void setMKD(double MKD) {
            this.MKD = MKD;
        }

        public void setMMK(double MMK) {
            this.MMK = MMK;
        }

        public void setMNT(double MNT) {
            this.MNT = MNT;
        }

        public void setMOP(double MOP) {
            this.MOP = MOP;
        }

        public void setMRO(double MRO) {
            this.MRO = MRO;
        }

        public void setMTL(double MTL) {
            this.MTL = MTL;
        }

        public void setMUR(double MUR) {
            this.MUR = MUR;
        }

        public void setMVR(double MVR) {
            this.MVR = MVR;
        }

        public void setMWK(double MWK) {
            this.MWK = MWK;
        }

        public void setMXN(double MXN) {
            this.MXN = MXN;
        }

        public void setMYR(double MYR) {
            this.MYR = MYR;
        }

        public void setMZN(double MZN) {
            this.MZN = MZN;
        }

        public void setNAD(double NAD) {
            this.NAD = NAD;
        }

        public void setNGN(double NGN) {
            this.NGN = NGN;
        }

        public void setNIO(double NIO) {
            this.NIO = NIO;
        }

        public void setNOK(double NOK) {
            this.NOK = NOK;
        }

        public void setNPR(double NPR) {
            this.NPR = NPR;
        }

        public void setNZD(double NZD) {
            this.NZD = NZD;
        }

        public void setOMR(double OMR) {
            this.OMR = OMR;
        }

        public void setPAB(int PAB) {
            this.PAB = PAB;
        }

        public void setPEN(double PEN) {
            this.PEN = PEN;
        }

        public void setPGK(double PGK) {
            this.PGK = PGK;
        }

        public void setPHP(double PHP) {
            this.PHP = PHP;
        }

        public void setPKR(double PKR) {
            this.PKR = PKR;
        }

        public void setPLN(double PLN) {
            this.PLN = PLN;
        }

        public void setPYG(double PYG) {
            this.PYG = PYG;
        }

        public void setQAR(double QAR) {
            this.QAR = QAR;
        }

        public void setRON(double RON) {
            this.RON = RON;
        }

        public void setRSD(double RSD) {
            this.RSD = RSD;
        }

        public void setRUB(double RUB) {
            this.RUB = RUB;
        }

        public void setRWF(double RWF) {
            this.RWF = RWF;
        }

        public void setSAR(double SAR) {
            this.SAR = SAR;
        }

        public void setSBD(double SBD) {
            this.SBD = SBD;
        }

        public void setSCR(double SCR) {
            this.SCR = SCR;
        }

        public void setSDG(double SDG) {
            this.SDG = SDG;
        }

        public void setSEK(double SEK) {
            this.SEK = SEK;
        }

        public void setSGD(double SGD) {
            this.SGD = SGD;
        }

        public void setSHP(double SHP) {
            this.SHP = SHP;
        }

        public void setSLL(double SLL) {
            this.SLL = SLL;
        }

        public void setSOS(double SOS) {
            this.SOS = SOS;
        }

        public void setSRD(double SRD) {
            this.SRD = SRD;
        }

        public void setSTD(double STD) {
            this.STD = STD;
        }

        public void setSVC(double SVC) {
            this.SVC = SVC;
        }

        public void setSYP(double SYP) {
            this.SYP = SYP;
        }

        public void setSZL(double SZL) {
            this.SZL = SZL;
        }

        public void setTHB(double THB) {
            this.THB = THB;
        }

        public void setTJS(double TJS) {
            this.TJS = TJS;
        }

        public void setTMT(double TMT) {
            this.TMT = TMT;
        }

        public void setTND(double TND) {
            this.TND = TND;
        }

        public void setTOP(double TOP) {
            this.TOP = TOP;
        }

        public void setTRY(double TRY) {
            this.TRY = TRY;
        }

        public void setTTD(double TTD) {
            this.TTD = TTD;
        }

        public void setTWD(double TWD) {
            this.TWD = TWD;
        }

        public void setTZS(double TZS) {
            this.TZS = TZS;
        }

        public void setUAH(double UAH) {
            this.UAH = UAH;
        }

        public void setUGX(double UGX) {
            this.UGX = UGX;
        }

        public void setUSD(int USD) {
            this.USD = USD;
        }

        public void setUYU(double UYU) {
            this.UYU = UYU;
        }

        public void setUZS(double UZS) {
            this.UZS = UZS;
        }

        public void setVEF(double VEF) {
            this.VEF = VEF;
        }

        public void setVND(int VND) {
            this.VND = VND;
        }

        public void setVUV(double VUV) {
            this.VUV = VUV;
        }

        public void setWST(double WST) {
            this.WST = WST;
        }

        public void setXAF(double XAF) {
            this.XAF = XAF;
        }

        public void setXAG(double XAG) {
            this.XAG = XAG;
        }

        public void setXAU(double XAU) {
            this.XAU = XAU;
        }

        public void setXCD(double XCD) {
            this.XCD = XCD;
        }

        public void setXDR(double XDR) {
            this.XDR = XDR;
        }

        public void setXOF(double XOF) {
            this.XOF = XOF;
        }

        public void setXPD(double XPD) {
            this.XPD = XPD;
        }

        public void setXPF(double XPF) {
            this.XPF = XPF;
        }

        public void setXPT(double XPT) {
            this.XPT = XPT;
        }

        public void setYER(double YER) {
            this.YER = YER;
        }

        public void setZAR(double ZAR) {
            this.ZAR = ZAR;
        }

        public void setZMK(double ZMK) {
            this.ZMK = ZMK;
        }

        public void setZMW(double ZMW) {
            this.ZMW = ZMW;
        }

        public void setZWL(double ZWL) {
            this.ZWL = ZWL;
        }

        public double getAED() {
            return AED;
        }

        public double getAFN() {
            return AFN;
        }

        public double getALL() {
            return ALL;
        }

        public double getAMD() {
            return AMD;
        }

        public double getANG() {
            return ANG;
        }

        public double getAOA() {
            return AOA;
        }

        public double getARS() {
            return ARS;
        }

        public double getAUD() {
            return AUD;
        }

        public double getAWG() {
            return AWG;
        }

        public double getAZN() {
            return AZN;
        }

        public double getBAM() {
            return BAM;
        }

        public int getBBD() {
            return BBD;
        }

        public double getBDT() {
            return BDT;
        }

        public double getBGN() {
            return BGN;
        }

        public double getBHD() {
            return BHD;
        }

        public double getBIF() {
            return BIF;
        }

        public int getBMD() {
            return BMD;
        }

        public double getBND() {
            return BND;
        }

        public double getBOB() {
            return BOB;
        }

        public double getBRL() {
            return BRL;
        }

        public int getBSD() {
            return BSD;
        }

        public double getBTC() {
            return BTC;
        }

        public double getBTN() {
            return BTN;
        }

        public double getBWP() {
            return BWP;
        }

        public int getBYR() {
            return BYR;
        }

        public double getBZD() {
            return BZD;
        }

        public double getCAD() {
            return CAD;
        }

        public double getCDF() {
            return CDF;
        }

        public double getCHF() {
            return CHF;
        }

        public double getCLF() {
            return CLF;
        }

        public double getCLP() {
            return CLP;
        }

        public double getCNY() {
            return CNY;
        }

        public double getCOP() {
            return COP;
        }

        public double getCRC() {
            return CRC;
        }

        public int getCUC() {
            return CUC;
        }

        public double getCUP() {
            return CUP;
        }

        public double getCVE() {
            return CVE;
        }

        public double getCZK() {
            return CZK;
        }

        public double getDJF() {
            return DJF;
        }

        public double getDKK() {
            return DKK;
        }

        public double getDOP() {
            return DOP;
        }

        public double getDZD() {
            return DZD;
        }

        public double getEEK() {
            return EEK;
        }

        public double getEGP() {
            return EGP;
        }

        public double getERN() {
            return ERN;
        }

        public double getETB() {
            return ETB;
        }

        public double getEUR() {
            return EUR;
        }

        public double getFJD() {
            return FJD;
        }

        public double getFKP() {
            return FKP;
        }

        public double getGBP() {
            return GBP;
        }

        public double getGEL() {
            return GEL;
        }

        public double getGGP() {
            return GGP;
        }

        public double getGHS() {
            return GHS;
        }

        public double getGIP() {
            return GIP;
        }

        public double getGMD() {
            return GMD;
        }

        public double getGNF() {
            return GNF;
        }

        public double getGTQ() {
            return GTQ;
        }

        public double getGYD() {
            return GYD;
        }

        public double getHKD() {
            return HKD;
        }

        public double getHNL() {
            return HNL;
        }

        public double getHRK() {
            return HRK;
        }

        public double getHTG() {
            return HTG;
        }

        public double getHUF() {
            return HUF;
        }

        public double getIDR() {
            return IDR;
        }

        public double getILS() {
            return ILS;
        }

        public double getIMP() {
            return IMP;
        }

        public double getINR() {
            return INR;
        }

        public double getIQD() {
            return IQD;
        }

        public int getIRR() {
            return IRR;
        }

        public double getISK() {
            return ISK;
        }

        public double getJEP() {
            return JEP;
        }

        public double getJMD() {
            return JMD;
        }

        public double getJOD() {
            return JOD;
        }

        public double getJPY() {
            return JPY;
        }

        public double getKES() {
            return KES;
        }

        public double getKGS() {
            return KGS;
        }

        public double getKHR() {
            return KHR;
        }

        public double getKMF() {
            return KMF;
        }

        public double getKPW() {
            return KPW;
        }

        public double getKRW() {
            return KRW;
        }

        public double getKWD() {
            return KWD;
        }

        public double getKYD() {
            return KYD;
        }

        public double getKZT() {
            return KZT;
        }

        public double getLAK() {
            return LAK;
        }

        public double getLBP() {
            return LBP;
        }

        public double getLKR() {
            return LKR;
        }

        public double getLRD() {
            return LRD;
        }

        public double getLSL() {
            return LSL;
        }

        public double getLTL() {
            return LTL;
        }

        public double getLVL() {
            return LVL;
        }

        public double getLYD() {
            return LYD;
        }

        public double getMAD() {
            return MAD;
        }

        public double getMDL() {
            return MDL;
        }

        public double getMGA() {
            return MGA;
        }

        public double getMKD() {
            return MKD;
        }

        public double getMMK() {
            return MMK;
        }

        public double getMNT() {
            return MNT;
        }

        public double getMOP() {
            return MOP;
        }

        public double getMRO() {
            return MRO;
        }

        public double getMTL() {
            return MTL;
        }

        public double getMUR() {
            return MUR;
        }

        public double getMVR() {
            return MVR;
        }

        public double getMWK() {
            return MWK;
        }

        public double getMXN() {
            return MXN;
        }

        public double getMYR() {
            return MYR;
        }

        public double getMZN() {
            return MZN;
        }

        public double getNAD() {
            return NAD;
        }

        public double getNGN() {
            return NGN;
        }

        public double getNIO() {
            return NIO;
        }

        public double getNOK() {
            return NOK;
        }

        public double getNPR() {
            return NPR;
        }

        public double getNZD() {
            return NZD;
        }

        public double getOMR() {
            return OMR;
        }

        public int getPAB() {
            return PAB;
        }

        public double getPEN() {
            return PEN;
        }

        public double getPGK() {
            return PGK;
        }

        public double getPHP() {
            return PHP;
        }

        public double getPKR() {
            return PKR;
        }

        public double getPLN() {
            return PLN;
        }

        public double getPYG() {
            return PYG;
        }

        public double getQAR() {
            return QAR;
        }

        public double getRON() {
            return RON;
        }

        public double getRSD() {
            return RSD;
        }

        public double getRUB() {
            return RUB;
        }

        public double getRWF() {
            return RWF;
        }

        public double getSAR() {
            return SAR;
        }

        public double getSBD() {
            return SBD;
        }

        public double getSCR() {
            return SCR;
        }

        public double getSDG() {
            return SDG;
        }

        public double getSEK() {
            return SEK;
        }

        public double getSGD() {
            return SGD;
        }

        public double getSHP() {
            return SHP;
        }

        public double getSLL() {
            return SLL;
        }

        public double getSOS() {
            return SOS;
        }

        public double getSRD() {
            return SRD;
        }

        public double getSTD() {
            return STD;
        }

        public double getSVC() {
            return SVC;
        }

        public double getSYP() {
            return SYP;
        }

        public double getSZL() {
            return SZL;
        }

        public double getTHB() {
            return THB;
        }

        public double getTJS() {
            return TJS;
        }

        public double getTMT() {
            return TMT;
        }

        public double getTND() {
            return TND;
        }

        public double getTOP() {
            return TOP;
        }

        public double getTRY() {
            return TRY;
        }

        public double getTTD() {
            return TTD;
        }

        public double getTWD() {
            return TWD;
        }

        public double getTZS() {
            return TZS;
        }

        public double getUAH() {
            return UAH;
        }

        public double getUGX() {
            return UGX;
        }

        public int getUSD() {
            return USD;
        }

        public double getUYU() {
            return UYU;
        }

        public double getUZS() {
            return UZS;
        }

        public double getVEF() {
            return VEF;
        }

        public int getVND() {
            return VND;
        }

        public double getVUV() {
            return VUV;
        }

        public double getWST() {
            return WST;
        }

        public double getXAF() {
            return XAF;
        }

        public double getXAG() {
            return XAG;
        }

        public double getXAU() {
            return XAU;
        }

        public double getXCD() {
            return XCD;
        }

        public double getXDR() {
            return XDR;
        }

        public double getXOF() {
            return XOF;
        }

        public double getXPD() {
            return XPD;
        }

        public double getXPF() {
            return XPF;
        }

        public double getXPT() {
            return XPT;
        }

        public double getYER() {
            return YER;
        }

        public double getZAR() {
            return ZAR;
        }

        public double getZMK() {
            return ZMK;
        }

        public double getZMW() {
            return ZMW;
        }

        public double getZWL() {
            return ZWL;
        }
    }
}
