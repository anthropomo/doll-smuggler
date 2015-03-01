(ns co.mlangdon.smugdoll-test
  (:require [clojure.test :refer :all]
            [co.mlangdon.smugdoll :refer :all]))

(deftest base-problem
  (testing "basic problem"
    (is
      (= 
        (knapsack dolls max-weight)
        [["sally" 4 50] ["eddie" 7 20] ["grumpy" 22 80] ["dusty" 43 75] 
         ["grumpkin" 42 70] ["marc" 11 70] ["randal" 27 60] ["puppy" 15 60] 
         ["dorothy" 50 160] ["candice" 153 200] ["anthony" 13 35] ["luke" 9 150]]))))

(def randvec 
  [["i0000" 122 281] ["i0001" 98 221] ["i0002" 126 211] ["i0003" 39 161] ["i0004" 47 86] ["i0005" 35 62] ["i0006" 7 85] ["i0007" 161 272]
	["i0008" 174 64] ["i0009" 166 151] ["i0010" 9 157] ["i0011" 143 137] ["i0012" 46 124] ["i0013" 167 22] ["i0014" 196 296] ["i0015" 151 296]
	["i0016" 126 277] ["i0017" 161 86] ["i0018" 48 130] ["i0019" 20 14] ["i0020" 73 7] ["i0021" 182 225] ["i0022" 19 235] ["i0023" 197 267]
	["i0024" 108 37] ["i0025" 55 147] ["i0026" 139 41] ["i0027" 18 198] ["i0028" 194 27] ["i0029" 158 285] ["i0030" 194 29] ["i0031" 14 259]
	["i0032" 1 258] ["i0033" 198 155] ["i0034" 153 264] ["i0035" 149 159] ["i0036" 25 292] ["i0037" 58 175] ["i0038" 77 72] ["i0039" 177 188]
	["i0040" 173 57] ["i0041" 19 288] ["i0042" 47 7] ["i0043" 188 165] ["i0044" 10 125] ["i0045" 70 1] ["i0046" 83 231] ["i0047" 27 84]
	["i0048" 36 208] ["i0049" 148 71] ["i0050" 52 211] ["i0051" 107 48] ["i0052" 59 2] ["i0053" 152 264] ["i0054" 80 296] ["i0055" 46 151]
	["i0056" 196 253] ["i0057" 92 260] ["i0058" 16 145] ["i0059" 68 218] ["i0060" 117 143] ["i0061" 153 256] ["i0062" 15 137] ["i0063" 44 114]
	["i0064" 64 217] ["i0065" 2 186] ["i0066" 17 76] ["i0067" 90 96] ["i0068" 72 228] ["i0069" 108 14] ["i0070" 32 218] ["i0071" 190 101]
	["i0072" 101 277] ["i0073" 120 122] ["i0074" 197 111] ["i0075" 145 284] ["i0076" 18 88] ["i0077" 147 78] ["i0078" 180 157] ["i0079" 56 84]
	["i0080" 3 255] ["i0081" 188 59] ["i0082" 103 213] ["i0083" 186 222] ["i0084" 106 32] ["i0085" 21 156] ["i0086" 20 247] ["i0087" 64 27]
	["i0088" 108 300] ["i0089" 114 206] ["i0090" 183 130] ["i0091" 79 140] ["i0092" 155 299] ["i0093" 60 258] ["i0094" 3 270] ["i0095" 154 90]
	["i0096" 71 287] ["i0097" 37 293] ["i0098" 143 150] ["i0099" 117 150] ["i0100" 13 33] ["i0101" 188 121] ["i0102" 195 272] ["i0103" 140 154]
	["i0104" 25 94] ["i0105" 116 250] ["i0106" 6 122] ["i0107" 3 184] ["i0108" 11 66] ["i0109" 74 205] ["i0110" 4 259] ["i0111" 126 192]
	["i0112" 1 64] ["i0113" 43 183] ["i0114" 85 172] ["i0115" 117 268] ["i0116" 129 299] ["i0117" 140 111] ["i0118" 87 225] ["i0119" 149 142]
	["i0120" 10 31] ["i0121" 125 56] ["i0122" 107 170] ["i0123" 25 28] ["i0124" 80 157] ["i0125" 153 86] ["i0126" 75 174] ["i0127" 155 83]
	["i0128" 149 2] ["i0129" 41 120] ["i0130" 26 49] ["i0131" 127 260] ["i0132" 6 149] ["i0133" 199 182] ["i0134" 195 3] ["i0135" 14 169]
	["i0136" 72 174] ["i0137" 23 177] ["i0138" 41 115] ["i0139" 170 295] ["i0140" 110 52] ["i0141" 50 286] ["i0142" 2 6] ["i0143" 129 165]
	["i0144" 187 101] ["i0145" 181 142] ["i0146" 61 30] ["i0147" 19 271] ["i0148" 20 285] ["i0149" 99 112] ["i0150" 119 166] ["i0151" 147 25]
	["i0152" 177 150] ["i0153" 130 225] ["i0154" 38 242] ["i0155" 100 237] ["i0156" 62 50] ["i0157" 114 65] ["i0158" 99 280] ["i0159" 69 249]
	["i0160" 110 136] ["i0161" 14 258] ["i0162" 110 234] ["i0163" 198 173] ["i0164" 186 19] ["i0165" 193 206] ["i0166" 42 249] ["i0167" 68 119]
	["i0168" 156 157] ["i0169" 150 85] ["i0170" 179 193] ["i0171" 157 192] ["i0172" 44 77] ["i0173" 85 221] ["i0174" 96 52] ["i0175" 1 52]
	["i0176" 138 183] ["i0177" 198 300] ["i0178" 96 268] ["i0179" 60 163] ["i0180" 175 249] ["i0181" 40 27] ["i0182" 180 8] ["i0183" 108 293]
	["i0184" 22 7] ["i0185" 111 212] ["i0186" 187 278] ["i0187" 91 114] ["i0188" 65 104] ["i0189" 178 8] ["i0190" 70 139] ["i0191" 68 239]
	["i0192" 4 125] ["i0193" 196 31] ["i0194" 147 234] ["i0195" 24 260] ["i0196" 12 52] ["i0197" 195 271] ["i0198" 113 102] ["i0199" 5 185]
	["i0200" 143 111] ["i0201" 131 36] ["i0202" 112 105] ["i0203" 33 165] ["i0204" 72 282] ["i0205" 70 61] ["i0206" 194 45] ["i0207" 168 192]
	["i0208" 88 170] ["i0209" 73 222] ["i0210" 120 2] ["i0211" 59 181] ["i0212" 166 248] ["i0213" 184 185] ["i0214" 194 227] ["i0215" 125 83]
	["i0216" 89 118] ["i0217" 80 278] ["i0218" 78 72] ["i0219" 15 74] ["i0220" 54 5] ["i0221" 23 258] ["i0222" 55 245] ["i0223" 157 216]
	["i0224" 158 92] ["i0225" 46 270] ["i0226" 38 168] ["i0227" 52 226] ["i0228" 180 297] ["i0229" 10 115] ["i0230" 22 213] ["i0231" 57 277]
	["i0232" 199 27] ["i0233" 98 149] ["i0234" 62 222] ["i0235" 50 82] ["i0236" 79 92] ["i0237" 104 293] ["i0238" 46 225] ["i0239" 92 40]
	["i0240" 54 134] ["i0241" 80 211] ["i0242" 61 222] ["i0243" 108 20] ["i0244" 139 165] ["i0245" 113 184] ["i0246" 11 100] ["i0247" 172 183]
	["i0248" 45 238] ["i0249" 29 204] ["i0250" 170 268] ["i0251" 25 153] ["i0252" 194 250] ["i0253" 90 255] ["i0254" 89 110] ["i0255" 115 129]
	["i0256" 18 264] ["i0257" 143 276] ["i0258" 146 263] ["i0259" 185 222] ["i0260" 71 90] ["i0261" 101 270] ["i0262" 180 176] ["i0263" 8 131]
	["i0264" 14 295] ["i0265" 100 45] ["i0266" 143 208] ["i0267" 18 228] ["i0268" 13 117] ["i0269" 196 155] ["i0270" 33 90] ["i0271" 125 193]
	["i0272" 96 145] ["i0273" 187 11] ["i0274" 13 213] ["i0275" 112 127] ["i0276" 181 64] ["i0277" 39 30] ["i0278" 156 239] ["i0279" 95 163]
	["i0280" 134 72] ["i0281" 144 116] ["i0282" 1 288] ["i0283" 77 186] ["i0284" 105 33] ["i0285" 173 143] ["i0286" 189 124] ["i0287" 179 200]
	["i0288" 74 60] ["i0289" 140 220] ["i0290" 136 180] ["i0291" 138 275] ["i0292" 75 207] ["i0293" 57 21] ["i0294" 182 185] ["i0295" 116 209]
	["i0296" 123 191] ["i0297" 99 164] ["i0298" 32 282] ["i0299" 121 238] ["i0300" 61 108] ["i0301" 52 289] ["i0302" 22 23] ["i0303" 170 149]
	["i0304" 61 149] ["i0305" 42 1] ["i0306" 92 155] ["i0307" 99 253] ["i0308" 132 268] ["i0309" 82 247] ["i0310" 77 214] ["i0311" 4 225]
	["i0312" 26 220] ["i0313" 105 173] ["i0314" 141 4] ["i0315" 51 7] ["i0316" 18 79] ["i0317" 190 205] ["i0318" 147 173] ["i0319" 136 182]
	["i0320" 178 220] ["i0321" 168 84] ["i0322" 45 26] ["i0323" 48 268] ["i0324" 60 5] ["i0325" 41 67] ["i0326" 187 98] ["i0327" 9 53]
	["i0328" 83 234] ["i0329" 38 164] ["i0330" 18 144] ["i0331" 17 16] ["i0332" 151 88] ["i0333" 33 126] ["i0334" 5 143] ["i0335" 136 130]
	["i0336" 119 289] ["i0337" 4 104] ["i0338" 85 129] ["i0339" 72 216] ["i0340" 3 127] ["i0341" 171 216] ["i0342" 156 187] ["i0343" 26 7]
	["i0344" 190 179] ["i0345" 150 132] ["i0346" 125 97] ["i0347" 37 25] ["i0348" 31 36] ["i0349" 64 207] ["i0350" 54 269] ["i0351" 160 194]
	["i0352" 16 164] ["i0353" 107 30] ["i0354" 160 137] ["i0355" 72 193] ["i0356" 44 259] ["i0357" 79 97] ["i0358" 8 146] ["i0359" 24 149]
	["i0360" 199 90] ["i0361" 175 121] ["i0362" 144 226] ["i0363" 186 33] ["i0364" 53 22] ["i0365" 100 7] ["i0366" 70 291] ["i0367" 142 259]
	["i0368" 68 180] ["i0369" 158 218] ["i0370" 17 24] ["i0371" 131 206] ["i0372" 184 278] ["i0373" 177 201] ["i0374" 70 40] ["i0375" 55 268]
	["i0376" 34 112] ["i0377" 14 125] ["i0378" 22 109] ["i0379" 194 71] ["i0380" 102 284] ["i0381" 117 275] ["i0382" 65 31] ["i0383" 53 15]
	["i0384" 40 11] ["i0385" 13 227] ["i0386" 169 266] ["i0387" 79 6] ["i0388" 19 177] ["i0389" 88 135] ["i0390" 2 196] ["i0391" 107 247]
	["i0392" 6 187] ["i0393" 7 129] ["i0394" 48 236] ["i0395" 200 27] ["i0396" 61 262] ["i0397" 53 74] ["i0398" 56 37] ["i0399" 37 95]
	["i0400" 29 154] ["i0401" 10 203] ["i0402" 107 122] ["i0403" 105 140] ["i0404" 77 121] ["i0405" 147 227] ["i0406" 107 238] ["i0407" 98 246]
	["i0408" 8 152] ["i0409" 188 93] ["i0410" 105 253] ["i0411" 8 78] ["i0412" 187 17] ["i0413" 106 256] ["i0414" 142 105] ["i0415" 125 177]
	["i0416" 184 92] ["i0417" 138 266] ["i0418" 2 217] ["i0419" 131 46] ["i0420" 94 240] ["i0421" 42 145] ["i0422" 140 155] ["i0423" 123 89]
	["i0424" 152 230] ["i0425" 168 63] ["i0426" 70 21] ["i0427" 190 17] ["i0428" 200 215] ["i0429" 37 251] ["i0430" 109 271] ["i0431" 56 58]
	["i0432" 134 145] ["i0433" 100 10] ["i0434" 7 196] ["i0435" 6 62] ["i0436" 89 298] ["i0437" 60 9] ["i0438" 105 271] ["i0439" 198 42]
	["i0440" 36 143] ["i0441" 49 228] ["i0442" 1 54] ["i0443" 22 132] ["i0444" 184 113] ["i0445" 55 43] ["i0446" 8 213] ["i0447" 175 189]
	["i0448" 175 91] ["i0449" 174 193] ["i0450" 45 117] ["i0451" 93 1] ["i0452" 43 121] ["i0453" 36 28] ["i0454" 136 78] ["i0455" 53 288]
	["i0456" 30 153] ["i0457" 127 202] ["i0458" 98 144] ["i0459" 1 139] ["i0460" 86 298] ["i0461" 195 53] ["i0462" 174 155] ["i0463" 129 131]
	["i0464" 44 205] ["i0465" 9 55] ["i0466" 16 27] ["i0467" 191 12] ["i0468" 68 41] ["i0469" 155 36] ["i0470" 51 166] ["i0471" 69 296]
	["i0472" 186 8] ["i0473" 172 296] ["i0474" 36 169] ["i0475" 119 202] ["i0476" 174 42] ["i0477" 21 21] ["i0478" 199 123] ["i0479" 185 246]
	["i0480" 159 36] ["i0481" 178 5] ["i0482" 180 203] ["i0483" 191 280] ["i0484" 77 19] ["i0485" 13 122] ["i0486" 170 291] ["i0487" 18 234]
	["i0488" 160 173] ["i0489" 161 106] ["i0490" 7 39] ["i0491" 167 29] ["i0492" 165 233] ["i0493" 163 45] ["i0494" 123 7] ["i0495" 55 223]
	["i0496" 162 211] ["i0497" 91 145] ["i0498" 18 79] ["i0499" 34 24] ["i0500" 47 125] ["i0501" 180 95] ["i0502" 75 10] ["i0503" 93 67]
	["i0504" 175 209] ["i0505" 29 133] ["i0506" 109 67] ["i0507" 39 85] ["i0508" 55 155] ["i0509" 106 197] ["i0510" 34 106] ["i0511" 46 75]
	["i0512" 38 8] ["i0513" 45 16] ["i0514" 31 282] ["i0515" 27 206] ["i0516" 108 109] ["i0517" 117 109] ["i0518" 19 269] ["i0519" 197 88]
	["i0520" 99 61] ["i0521" 123 179] ["i0522" 23 239] ["i0523" 3 280] ["i0524" 183 57] ["i0525" 46 102] ["i0526" 121 253] ["i0527" 171 196]
	["i0528" 143 261] ["i0529" 39 84] ["i0530" 152 32] ["i0531" 153 245] ["i0532" 81 144] ["i0533" 196 173] ["i0534" 8 174] ["i0535" 132 96]
	["i0536" 6 133] ["i0537" 108 175] ["i0538" 118 57] ["i0539" 10 76] ["i0540" 107 188] ["i0541" 5 160] ["i0542" 149 138] ["i0543" 6 48]
	["i0544" 94 33] ["i0545" 147 269] ["i0546" 41 35] ["i0547" 132 279] ["i0548" 47 252] ["i0549" 27 201] ["i0550" 3 41] ["i0551" 4 59]
	["i0552" 172 29] ["i0553" 1 228] ["i0554" 1 176] ["i0555" 183 20] ["i0556" 136 110] ["i0557" 194 68] ["i0558" 154 210] ["i0559" 30 203]
	["i0560" 81 180] ["i0561" 107 166] ["i0562" 116 152] ["i0563" 7 149] ["i0564" 141 299] ["i0565" 111 267] ["i0566" 109 231] ["i0567" 38 161]
	["i0568" 88 292] ["i0569" 173 109] ["i0570" 24 7] ["i0571" 94 152] ["i0572" 36 240] ["i0573" 2 230] ["i0574" 134 95] ["i0575" 128 212]
	["i0576" 86 279] ["i0577" 159 188] ["i0578" 167 222] ["i0579" 40 174] ["i0580" 175 140] ["i0581" 14 164] ["i0582" 63 252] ["i0583" 129 41]
	["i0584" 28 164] ["i0585" 179 142] ["i0586" 103 202] ["i0587" 190 36] ["i0588" 71 80] ["i0589" 50 297] ["i0590" 192 169] ["i0591" 189 298]
	["i0592" 154 209] ["i0593" 11 160] ["i0594" 154 274] ["i0595" 172 136] ["i0596" 31 97] ["i0597" 83 96] ["i0598" 102 173] ["i0599" 29 149]
	["i0600" 175 126] ["i0601" 25 85] ["i0602" 154 263] ["i0603" 105 251] ["i0604" 142 172] ["i0605" 140 278] ["i0606" 96 63] ["i0607" 16 154]
	["i0608" 152 54] ["i0609" 195 206] ["i0610" 40 267] ["i0611" 60 238] ["i0612" 51 164] ["i0613" 84 285] ["i0614" 9 283] ["i0615" 145 120]
	["i0616" 110 151] ["i0617" 55 262] ["i0618" 124 43] ["i0619" 152 115] ["i0620" 10 290] ["i0621" 165 231] ["i0622" 117 234] ["i0623" 63 290]
	["i0624" 70 207] ["i0625" 37 204] ["i0626" 50 111] ["i0627" 74 37] ["i0628" 96 183] ["i0629" 154 146] ["i0630" 25 172] ["i0631" 123 155]
	["i0632" 195 225] ["i0633" 126 82] ["i0634" 134 190] ["i0635" 15 268] ["i0636" 78 192] ["i0637" 90 107] ["i0638" 85 215] ["i0639" 27 85]
	["i0640" 104 164] ["i0641" 22 298] ["i0642" 152 12] ["i0643" 129 290] ["i0644" 185 47] ["i0645" 91 160] ["i0646" 36 194] ["i0647" 184 287]
	["i0648" 82 255] ["i0649" 181 178] ["i0650" 91 72] ["i0651" 89 84] ["i0652" 1 289] ["i0653" 196 199] ["i0654" 95 19] ["i0655" 177 40]
	["i0656" 72 5] ["i0657" 5 259] ["i0658" 93 253] ["i0659" 68 129] ["i0660" 12 243] ["i0661" 162 26] ["i0662" 1 233] ["i0663" 59 100]
	["i0664" 112 34] ["i0665" 165 158] ["i0666" 13 152] ["i0667" 196 219] ["i0668" 39 140] ["i0669" 61 221] ["i0670" 170 224] ["i0671" 133 247]
	["i0672" 186 15] ["i0673" 179 266] ["i0674" 145 240] ["i0675" 159 287] ["i0676" 117 201] ["i0677" 52 233] ["i0678" 14 152] ["i0679" 52 243]
	["i0680" 108 50] ["i0681" 69 112] ["i0682" 91 140] ["i0683" 36 146] ["i0684" 77 11] ["i0685" 199 50] ["i0686" 14 237] ["i0687" 143 290]
	["i0688" 129 160] ["i0689" 105 52] ["i0690" 77 279] ["i0691" 46 33] ["i0692" 172 183] ["i0693" 6 185] ["i0694" 167 28] ["i0695" 159 22]
	["i0696" 189 108] ["i0697" 48 291] ["i0698" 134 181] ["i0699" 112 188] ["i0700" 171 283] ["i0701" 161 74] ["i0702" 172 72] ["i0703" 132 242]
	["i0704" 141 287] ["i0705" 186 273] ["i0706" 72 68] ["i0707" 106 186] ["i0708" 193 54] ["i0709" 99 267] ["i0710" 134 126] ["i0711" 147 250]
	["i0712" 54 277] ["i0713" 185 152] ["i0714" 32 153] ["i0715" 38 193] ["i0716" 134 38] ["i0717" 107 162] ["i0718" 182 65] ["i0719" 105 291]
	["i0720" 40 211] ["i0721" 138 141] ["i0722" 126 25] ["i0723" 41 102] ["i0724" 173 167] ["i0725" 116 213] ["i0726" 83 280] ["i0727" 65 47]
	["i0728" 15 58] ["i0729" 71 148] ["i0730" 73 233] ["i0731" 81 270] ["i0732" 135 14] ["i0733" 165 115] ["i0734" 97 199] ["i0735" 192 31]
	["i0736" 93 136] ["i0737" 148 250] ["i0738" 117 221] ["i0739" 148 81] ["i0740" 61 95] ["i0741" 190 232] ["i0742" 181 181] ["i0743" 168 260]
	["i0744" 110 220] ["i0745" 46 7] ["i0746" 148 282] ["i0747" 85 171] ["i0748" 182 53] ["i0749" 150 290] ["i0750" 137 156] ["i0751" 73 202]
	["i0752" 164 257] ["i0753" 170 95] ["i0754" 45 115] ["i0755" 66 118] ["i0756" 103 113] ["i0757" 109 217] ["i0758" 72 76] ["i0759" 180 160]
	["i0760" 82 291] ["i0761" 109 120] ["i0762" 116 147] ["i0763" 19 178] ["i0764" 17 104] ["i0765" 157 42] ["i0766" 147 114] ["i0767" 143 38]
	["i0768" 71 57] ["i0769" 169 228] ["i0770" 6 172] ["i0771" 5 270] ["i0772" 44 295] ["i0773" 61 234] ["i0774" 98 258] ["i0775" 132 215]
	["i0776" 3 114] ["i0777" 200 287] ["i0778" 159 138] ["i0779" 167 62] ["i0780" 199 253] ["i0781" 35 73] ["i0782" 34 271] ["i0783" 63 269]
	["i0784" 19 182] ["i0785" 103 51] ["i0786" 92 99] ["i0787" 104 149] ["i0788" 88 57] ["i0789" 44 283] ["i0790" 200 39] ["i0791" 172 55]
	["i0792" 147 287] ["i0793" 120 116] ["i0794" 165 155] ["i0795" 187 172] ["i0796" 145 248] ["i0797" 149 127] ["i0798" 71 64] ["i0799" 132 133]
	["i0800" 112 264] ["i0801" 160 93] ["i0802" 100 26] ["i0803" 21 223] ["i0804" 181 274] ["i0805" 198 222] ["i0806" 147 264] ["i0807" 30 259]
	["i0808" 133 1] ["i0809" 13 119] ["i0810" 41 72] ["i0811" 78 122] ["i0812" 192 244] ["i0813" 9 209] ["i0814" 170 219] ["i0815" 60 231]
	["i0816" 117 203] ["i0817" 148 27] ["i0818" 136 261] ["i0819" 69 134] ["i0820" 40 152] ["i0821" 17 48] ["i0822" 141 228] ["i0823" 153 148]
	["i0824" 7 224] ["i0825" 134 124] ["i0826" 51 254] ["i0827" 134 215] ["i0828" 126 21] ["i0829" 20 100] ["i0830" 47 231] ["i0831" 107 145]
	["i0832" 47 110] ["i0833" 55 99] ["i0834" 15 201] ["i0835" 42 239] ["i0836" 118 290] ["i0837" 158 261] ["i0838" 175 227] ["i0839" 40 96]
	["i0840" 62 186] ["i0841" 50 239] ["i0842" 165 195] ["i0843" 41 259] ["i0844" 57 109] ["i0845" 158 129] ["i0846" 15 132] ["i0847" 107 259]
	["i0848" 174 189] ["i0849" 42 112] ["i0850" 137 273] ["i0851" 24 112] ["i0852" 88 226] ["i0853" 108 170] ["i0854" 155 211] ["i0855" 141 106]
	["i0856" 104 42] ["i0857" 49 169] ["i0858" 92 244] ["i0859" 41 224] ["i0860" 139 91] ["i0861" 92 120] ["i0862" 96 55] ["i0863" 165 76]
	["i0864" 62 45] ["i0865" 12 146] ["i0866" 179 148] ["i0867" 70 199] ["i0868" 108 49] ["i0869" 118 164] ["i0870" 105 282] ["i0871" 63 96]
	["i0872" 152 94] ["i0873" 20 4] ["i0874" 17 60] ["i0875" 172 185] ["i0876" 83 136] ["i0877" 169 68] ["i0878" 79 138] ["i0879" 57 195]
	["i0880" 26 214] ["i0881" 12 247] ["i0882" 10 125] ["i0883" 152 52] ["i0884" 111 163] ["i0885" 170 19] ["i0886" 22 69] ["i0887" 160 212]
	["i0888" 27 117] ["i0889" 186 144] ["i0890" 143 200] ["i0891" 103 209] ["i0892" 106 281] ["i0893" 162 186] ["i0894" 113 166] ["i0895" 39 157]
	["i0896" 60 104] ["i0897" 62 276] ["i0898" 19 137] ["i0899" 46 215] ["i0900" 123 26] ["i0901" 12 152] ["i0902" 192 132] ["i0903" 29 138]
	["i0904" 128 149] ["i0905" 161 17] ["i0906" 175 138] ["i0907" 141 256] ["i0908" 103 146] ["i0909" 30 179] ["i0910" 84 59] ["i0911" 60 32]
	["i0912" 130 114] ["i0913" 37 28] ["i0914" 11 233] ["i0915" 58 168] ["i0916" 105 100] ["i0917" 94 18] ["i0918" 192 142] ["i0919" 89 24]
	["i0920" 25 53] ["i0921" 128 194] ["i0922" 40 162] ["i0923" 71 50] ["i0924" 187 256] ["i0925" 102 82] ["i0926" 62 265] ["i0927" 160 25]
	["i0928" 69 232] ["i0929" 21 217] ["i0930" 171 225] ["i0931" 27 298] ["i0932" 137 179] ["i0933" 64 288] ["i0934" 40 75] ["i0935" 197 198]
	["i0936" 182 68] ["i0937" 103 2] ["i0938" 76 189] ["i0939" 165 158] ["i0940" 31 27] ["i0941" 127 111] ["i0942" 190 271] ["i0943" 62 226]
	["i0944" 161 148] ["i0945" 65 298] ["i0946" 192 47] ["i0947" 182 86] ["i0948" 102 100] ["i0949" 180 63] ["i0950" 123 27] ["i0951" 12 88]
	["i0952" 109 263] ["i0953" 110 37] ["i0954" 47 124] ["i0955" 175 85] ["i0956" 111 141] ["i0957" 64 253] ["i0958" 36 267] ["i0959" 49 2]
	["i0960" 89 112] ["i0961" 32 97] ["i0962" 101 6] ["i0963" 148 83] ["i0964" 160 123] ["i0965" 10 201] ["i0966" 182 69] ["i0967" 47 73]
	["i0968" 75 232] ["i0969" 142 60] ["i0970" 73 190] ["i0971" 130 214] ["i0972" 63 138] ["i0973" 54 226] ["i0974" 154 23] ["i0975" 89 168]
	["i0976" 163 288] ["i0977" 8 273] ["i0978" 117 50] ["i0979" 100 205] ["i0980" 60 62] ["i0981" 168 43] ["i0982" 165 227] ["i0983" 133 218]
	["i0984" 22 275] ["i0985" 82 256] ["i0986" 7 144] ["i0987" 113 83] ["i0988" 184 175] ["i0989" 11 131] ["i0990" 185 143] ["i0991" 69 126]
	["i0992" 99 246] ["i0993" 6 298] ["i0994" 16 113] ["i0995" 56 198] ["i0996" 142 244] ["i0997" 109 232] ["i0998" 185 172] ["i0999" 124 7]])

(deftest larger-set
 (testing "with set of 1000 items and 250 weight limit"
    (is (= (knapsack randvec 250)
           [["i0993" 6 298] ["i0986" 7 144] ["i0977" 8 273] ["i0965" 10 201] ["i0914" 11 233] ["i0881" 12 247] 
            ["i0824" 7 224] ["i0813" 9 209] ["i0776" 3 114] ["i0771" 5 270] ["i0770" 6 172] ["i0693" 6 185] 
            ["i0662" 1 233] ["i0657" 5 259] ["i0652" 1 289] ["i0620" 10 290] ["i0614" 9 283] ["i0573" 2 230] 
            ["i0563" 7 149] ["i0554" 1 176] ["i0553" 1 228] ["i0541" 5 160] ["i0536" 6 133] ["i0534" 8 174] 
            ["i0523" 3 280] ["i0459" 1 139] ["i0446" 8 213] ["i0442" 1 54] ["i0434" 7 196] ["i0418" 2 217] 
            ["i0401" 10 203] ["i0392" 6 187] ["i0390" 2 196] ["i0340" 3 127] ["i0337" 4 104] ["i0334" 5 143] 
            ["i0311" 4 225] ["i0282" 1 288] ["i0264" 14 295] ["i0199" 5 185] ["i0192" 4 125] ["i0175" 1 52] 
            ["i0132" 6 149] ["i0112" 1 64] ["i0110" 4 259] ["i0107" 3 184] ["i0094" 3 270] ["i0080" 3 255] 
            ["i0065" 2 186] ["i0032" 1 258]]
    ))
))

