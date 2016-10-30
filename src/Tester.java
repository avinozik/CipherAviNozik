import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		public static final String x = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:"
				+ '\n' + '\r';
		
		String plainText = "Nima's pants are on fire!!!?!!";
		String cipherText = Cipher.rotationCipherEncrypt(plainText, 3);

		System.out.println("Plaintext: " + plainText);
		System.out.println("Cipertext: " + cipherText);

		Dictionary d = Dictionary.buildDictionary("E:/ciphers/words.txt");
		System.out.println(d.isWord("banana"));
		
		
		String x = "7CD:TwJs:0wGHoysG:7voH:WBHsFtsFs:,wHv:O:UCCr:ZwtsnnnnTCF:AoBM:MsoFG:W:KCFysr:wB:DozzwoHwJs:qoFs?:0M:DoHwsBHG:KsFs:HvCGs:KvC:vor:uCBs:vCAs:HC:rws?:6CAs:wBqFsrwpzM:GDsqwoz:HwAsG:KsFs:GvoFsr?:W:KoG:KwHv:HvsA:tCF:Hvs:zoGH:HvFss:HC:HKszJs:KssyG:Ct:HvswF:zwJsG?nnnn3sCDzs:uFCK:o:zCH:KvsB:HvsM:oFs:toqsr:KwHv:HvswF:CKB:ACFHozwHM?:W:zsoFBH:BsJsF:HC:IBrsFsGHwAoHs:GCAsCBsrG:qoDoqwHM:tCF:uFCKHv?:6CAs:qvoBusG:KsFs:DvsBCAsBoz?:Soqv:sLDsFwsBqsr:o:JoFwsHM:Ct:sACHwCBG;:oG:sLDsqHsr;:rsBwoz;:tsoF;:oBusF;:FsACFGs;:ACFs:rsBwoz:oBr:sJsBHIozzM:oqqsDHoBqs?:SJsFM:GwBuzs:DoHwsBH:tCIBr:HvswF:Dsoqs:pstCFs:HvsM:rsDoFHsr:HvCIuv;:sJsFM:CBs:Ct:HvsA?:nnnn,vsB:EIsGHwCBsr:opCIH:oBM:FsuFsHG:HvsM:vor:CF:oBMHvwBu:HvsM:KCIzr:rC:rwttsFsBHzM;:qCAACB:HvsAsG:GIFtoqsr:ouowB:oBr:ouowB?:VsFs:oFs:Hvs:ACGH:qCAACB:twJslnnnn'?:W:KwGv:Wrr:vor:Hvs:qCIFous:HC:zwJs:o:zwts:HFIs:HC:AMGszt;:BCH:Hvs:zwts:CHvsFG:sLDsqHsr:Ct:As?:nnnn7vwG:KoG:Hvs:ACGH:qCAACB:FsuFsH:Ct:ozz?:,vsB:DsCDzs:FsozwGs:HvoH:HvswF:zwts:wG:ozACGH:CJsF:oBr:zCCy:poqy:qzsoFzM:CB:wH;:wH:wG:soGM:HC:Gss:vCK:AoBM:rFsoAG:voJs:uCBs:IBtIztwzzsr?:0CGH:DsCDzs:vor:BCH:vCBCIFsr:sJsB:o:vozt:Ct:HvswF:rFsoAG:oBr:vor:HC:rws:yBCKwBu:HvoH:wH:KoG:rIs:HC:qvCwqsG:HvsM:vor:Aors;:CF:BCH:Aors?:nnnnWH:wG:JsFM:wADCFHoBH:HC:HFM:oBr:vCBCIF:oH:zsoGH:GCAs:Ct:MCIF:rFsoAG:ozCBu:Hvs:KoM?:TFCA:Hvs:ACAsBH:HvoH:MCI:zCGs:MCIF:vsozHv;:wH:wG:HCC:zoHs?:VsozHv:pFwBuG:o:tFssrCA:JsFM:tsK:FsozwGs;:IBHwz:HvsM:BC:zCBusF:voJs:wH?nnnn" != null?:W:KwGv:W:rwrBrH:KCFy:GC:voFr?:nnnn7vwG:qoAs:tFCA:sJsFM:Aozs:DoHwsBH:HvoH:W:BIFGsr?:7vsM:AwGGsr:HvswF:qvwzrFsBrG:MCIHv:oBr:HvswF:DoFHBsFrG:qCADoBwCBGvwD?:,CAsB:ozGC:GDCys:Ct:HvwG:FsuFsH?:PIH:oG:ACGH:KsFs:tFCA:oB:CzrsF:usBsFoHwCB;:AoBM:Ct:Hvs:tsAozs:DoHwsBHG:vor:BCH:pssB:pFsorKwBBsFG?:Ozz:Ct:Hvs:AsB:W:BIFGsr:rssDzM:FsuFsHHsr:GDsBrwBu:GC:AIqv:Ct:HvswF:zwJsG:CB:Hvs:HFsorAwzz:Ct:o:KCFy:sLwGHsBqs?:nnnnPM:GwADzwtMwBu:MCIF:zwtsGHMzs:oBr:AoywBu:qCBGqwCIG:qvCwqsG:ozCBu:Hvs:KoM;:wH:wG:DCGGwpzs:HC:BCH:Bssr:Hvs:wBqCAs:HvoH:MCI:HvwBy:MCI:rC?:OBr:pM:qFsoHwBu:ACFs:GDoqs:wB:MCIF:zwts;:MCI:psqCAs:voDDwsF:oBr:ACFs:CDsB:HC:BsK:CDDCFHIBwHwsG;:CBsG:ACFs:GIwHsr:HC:MCIF:BsK:zwtsGHMzs?:nnnn!?:W:KwGv:Wrr:vor:Hvs:qCIFous:HC:sLDFsGG:AM:tsszwBuG?nnnn0oBM:DsCDzs:GIDDFsGGsr:HvswF:tsszwBuG:wB:CFrsF:HC:yssD:Dsoqs:KwHv:CHvsFG?:OG:o:FsGIzH;:HvsM:GsHHzsr:tCF:o:AsrwCqFs:sLwGHsBqs:oBr:BsJsF:psqoAs:KvC:HvsM:KsFs:HFIzM:qoDopzs:Ct:psqCAwBu?:0oBM:rsJszCDsr:wzzBsGGsG:FszoHwBu:HC:Hvs:pwHHsFBsGG:oBr:FsGsBHAsBH:HvsM:qoFFwsr:oG:o:FsGIzH?:nnnn,s:qoBBCH:qCBHFCz:Hvs:FsoqHwCBG:Ct:CHvsFG?:VCKsJsF;:ozHvCIuv:DsCDzs:AoM:wBwHwozzM:FsoqH:KvsB:MCI:qvoBus:Hvs:KoM:MCI:oFs:pM:GDsoywBu:vCBsGHzM;:wB:Hvs:sBr:wH:FowGsG:Hvs:FszoHwCBGvwD:HC:o:KvCzs:BsK:oBr:vsozHvwsF:zsJsz?:SwHvsF:HvoH:CF:wH:FszsoGsG:Hvs:IBvsozHvM:FszoHwCBGvwD:tFCA:MCIF:zwts?:SwHvsF:KoM;:MCI:KwB?:nnnn[?:W:KwGv:W:vor:GHoMsr:wB:HCIqv:KwHv:AM:tFwsBrG?:nnnn2tHsB:HvsM:KCIzr:BCH:HFIzM:FsozwGs:Hvs:tIzz:psBstwHG:Ct:Czr:tFwsBrG:IBHwz:HvswF:rMwBu:KssyG:oBr:wH:KoG:BCH:ozKoMG:DCGGwpzs:HC:HFoqy:HvsA:rCKB?:0oBM:vor:psqCAs:GC:qoIuvH:ID:wB:HvswF:CKB:zwJsG:HvoH:HvsM:vor:zsH:uCzrsB:tFwsBrGvwDG:GzwD:pM:CJsF:Hvs:MsoFG?:7vsFs:KsFs:AoBM:rssD:FsuFsHG:opCIH:BCH:uwJwBu:tFwsBrGvwDG:Hvs:HwAs:oBr:sttCFH:HvoH:HvsM:rsGsFJsr?:SJsFMCBs:AwGGsG:HvswF:tFwsBrG:KvsB:HvsM:oFs:rMwBu?:nnnnWH:wG:qCAACB:tCF:oBMCBs:wB:o:pIGM:zwtsGHMzs:HC:zsH:tFwsBrGvwDG:GzwD?:PIH:KvsB:MCI:oFs:toqsr:KwHv:MCIF:oDDFCoqvwBu:rsoHv;:Hvs:DvMGwqoz:rsHowzG:Ct:zwts:tozz:oKoM?:3sCDzs:rC:KoBH:HC:usH:HvswF:twBoBqwoz:ottowFG:wB:CFrsF:wt:DCGGwpzs?:PIH:wH:wG:BCH:ACBsM:CF:GHoHIG:HvoH:vCzrG:Hvs:HFIs:wADCFHoBqs:tCF:HvsA?:7vsM:KoBH:HC:usH:HvwBuG:wB:CFrsF:ACFs:tCF:Hvs:psBstwH:Ct:HvCGs:HvsM:zCJs?:8GIozzM:HvCIuv;:HvsM:oFs:HCC:wzz:oBr:KsoFM:HC:sJsF:AoBous:HvwG:HoGy?:WH:wG:ozz:qCAsG:rCKB:HC:zCJs:oBr:FszoHwCBGvwDG:wB:Hvs:sBr?:7voH:wG:ozz:HvoH:FsAowBG:wB:Hvs:twBoz:KssyG;:zCJs:oBr:FszoHwCBGvwDG?:nnnn]?:W:KwGv:HvoH:W:vor:zsH:AMGszt:ps:voDDwsF?:nnnn7vwG:wG:o:GIFDFwGwBuzM:qCAACB:CBs?:0oBM:rwr:BCH:FsozwGs:IBHwz:Hvs:sBr:HvoH:voDDwBsGG:wG:o:qvCwqs?:7vsM:vor:GHoMsr:GHIqy:wB:Czr:DoHHsFBG:oBr:vopwHG?:7vs:GCfqozzsr:rqCAtCFHr:Ct:toAwzwoFwHM:CJsFtzCKsr:wBHC:HvswF:sACHwCBG;:oG:Kszz:oG:HvswF:DvMGwqoz:zwJsG?:TsoF:Ct:qvoBus:vor:HvsA:DFsHsBrwBu:HC:CHvsFG;:oBr:HC:HvswF:GszJsG;:HvoH:HvsM:KsFs:qCBHsBH?:,vsB:rssD:KwHvwB;:HvsM:zCBusr:HC:zoIuv:DFCDsFzM:oBr:voJs:GwzzwBsGG:wB:HvswF:zwts:ouowB?:nnnn,vsB:MCI:oFs:CB:MCIF:rsoHvpsr;:KvoH:CHvsFG:HvwBy:Ct:MCI:wG:o:zCBu:KoM:tFCA:MCIF:AwBr?:VCK:KCBrsFtIz:HC:ps:opzs:HC:zsH:uC:oBr:GAwzs:ouowB;:zCBu:pstCFs:MCI:oFs:rMwBu?:nnnnnnZwts:wG:o:qvCwqs?:WH:wG:(285:zwts?:QvCCGs:qCBGqwCIGzM;:qvCCGs:KwGszM;:qvCCGs:vCBsGHzM?:QvCCGs:voDDwBsGG?";
		
	
		String a = Cipher.crackCipher1(x, APLHABET);
				
				
		
		
		
		
		
		
		
		
		

	}
}