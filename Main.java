import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random rand = new Random();

		String atl = "Atlantic";
		String met = "Metropolitan";
		String pac = "Pacific";
		String cen = "Central";

		Map<String, String> ana = new LinkedHashMap<String, String>();
		ana.put("ANA", pac);
		Map<String, String> ari = new LinkedHashMap<String, String>();
		ari.put("ARI", pac);
		Map<String, String> cgy = new LinkedHashMap<String, String>();
		cgy.put("CGY", pac);
		Map<String, String> edm = new LinkedHashMap<String, String>();
		edm.put("EDM", pac);
		Map<String, String> lak = new LinkedHashMap<String, String>();
		lak.put("LAK", pac);
		Map<String, String> sjs = new LinkedHashMap<String, String>();
		sjs.put("SJS", pac);
		Map<String, String> van = new LinkedHashMap<String, String>();
		van.put("VAN", pac);
		Map<String, String> vgk = new LinkedHashMap<String, String>();
		vgk.put("VGK", pac);
		Map<String, String> chi = new LinkedHashMap<String, String>();
		chi.put("CHI", cen);
		Map<String, String> col = new LinkedHashMap<String, String>();
		col.put("COL", cen);
		Map<String, String> dal = new LinkedHashMap<String, String>();
		dal.put("DAL", cen);
		Map<String, String> min = new LinkedHashMap<String, String>();
		min.put("MIN", cen);
		Map<String, String> nsh = new LinkedHashMap<String, String>();
		nsh.put("NSH", cen);
		Map<String, String> stl = new LinkedHashMap<String, String>();
		stl.put("STL", cen);
		Map<String, String> wpg = new LinkedHashMap<String, String>();
		wpg.put("WPG", cen);
		Map<String, String> bos = new LinkedHashMap<String, String>();
		bos.put("BOS", atl);
		Map<String, String> buf = new LinkedHashMap<String, String>();
		buf.put("BUF", atl);
		Map<String, String> det = new LinkedHashMap<String, String>();
		det.put("DET", atl);
		Map<String, String> fla = new LinkedHashMap<String, String>();
		fla.put("FLA", atl);
		Map<String, String> mtl = new LinkedHashMap<String, String>();
		mtl.put("MTL", atl);
		Map<String, String> ott = new LinkedHashMap<String, String>();
		ott.put("OTT", atl);
		Map<String, String> tbl = new LinkedHashMap<String, String>();
		tbl.put("TBL", atl);
		Map<String, String> tor = new LinkedHashMap<String, String>();
		tor.put("TOR", atl);
		Map<String, String> car = new LinkedHashMap<String, String>();
		car.put("CAR", met);
		Map<String, String> cbj = new LinkedHashMap<String, String>();
		cbj.put("CBJ", met);
		Map<String, String> njd = new LinkedHashMap<String, String>();
		njd.put("NJD", met);
		Map<String, String> nyi = new LinkedHashMap<String, String>();
		nyi.put("NYI", met);
		Map<String, String> nyr = new LinkedHashMap<String, String>();
		nyr.put("NYR", met);
		Map<String, String> phi = new LinkedHashMap<String, String>();
		phi.put("PHI", met);
		Map<String, String> pit = new LinkedHashMap<String, String>();
		pit.put("PIT", met);
		Map<String, String> wsh = new LinkedHashMap<String, String>();
		wsh.put("WSH", met);

		Map<String, Map<String, String>> west = new LinkedHashMap<String, Map<String, String>>();
		west.put("ANA", ana);
		west.put("ARI", ari);
		west.put("CGY", cgy);
		west.put("EDM", edm);
		west.put("LAK", lak);
		west.put("SJS", sjs);
		west.put("VAN", van);
		west.put("VGK", vgk);
		west.put("CHI", chi);
		west.put("COL", col);
		west.put("DAL", dal);
		west.put("MIN", min);
		west.put("NSH", nsh);
		west.put("STL", stl);
		west.put("WPG", wpg);
		Map<String, Map<String, String>> east = new LinkedHashMap<String, Map<String, String>>();
		east.put("BOS", bos);
		east.put("BUF", buf);
		east.put("DET", det);
		east.put("FLA", fla);
		east.put("MTL", mtl);
		east.put("OTT", ott);
		east.put("TBL", tbl);
		east.put("TOR", tor);
		east.put("CAR", car);
		east.put("CBJ", cbj);
		east.put("NJD", njd);
		east.put("NYI", nyi);
		east.put("NYR", nyr);
		east.put("PHI", phi);
		east.put("PIT", pit);
		east.put("WSH", wsh);

		ArrayList<String> games = new ArrayList<String>();
		for (int g = 1; g < 200; g++) {
			String gval = g + "";
			games.add(gval);
		}
//for (team t : list)
		east.forEach((team, tsched) -> {
			east.forEach((opp, osched) -> {
				if (opp != team && tsched.containsValue(opp) == false) {
					tsched.forEach((d, t) -> {
						games.remove(d);
					});
					osched.forEach((d, t) -> {
						games.remove(d);
					});
					System.out.println(team);
					System.out.println(games);
//					System.out.println("OUT OF THELOP");
					if (osched.get(opp) == tsched.get(team)) { //if the division is the same
						for (int d = 4; d > 0; d--) {
							int gnum = games.size();
							int dateint = rand.nextInt(gnum);
							String date = games.get(dateint) + "";
							
							
//							while (tsched.containsKey(date) || osched.containsKey(date)) {
//								dateint = rand.nextInt(gnum);
//								date = dateint + 1 + "";
////								System.out.println("1");
//							}
							tsched.put(date, opp);
							osched.put(date, team);
							games.remove(date);
						}
					} else {
						for (int d = 3; d > 0; d--) {
							int gnum = games.size();
							int dateint = rand.nextInt(gnum);
							String date = games.get(dateint) + "";
//							while (tsched.containsKey(date) || osched.containsKey(date)) {
//////								System.out.println(tsched.keySet().size() + team);
////								dateint = rand.nextInt(gnum);
////								date = dateint + 1 + "";
////								//System.out.println("2");
//							}
							tsched.put(date, opp);
							osched.put(date, team);
//							games.remove(date);
						}
					}
				}
			});
			west.forEach((opp, osched) -> {
				if (tsched.containsValue(opp) == false) {
					tsched.forEach((d, t) -> {
						games.remove(d);
					});
					osched.forEach((d, t) -> {
						games.remove(d);
					});
					for (int d = 2; d > 0; d--) {
						int gnum = games.size();
						int dateint = rand.nextInt(gnum);
						String date = games.get(dateint) +  "";
//						while (tsched.containsKey(date) || osched.containsKey(date)) {
//							dateint = rand.nextInt(gnum);
//							date = dateint + 1 + "";
////							System.out.println("3");
//						}
						tsched.put(date, opp);
						osched.put(date, team);
						games.remove(date);
					}
				}
			});
			games.clear();
			for (int g = 1; g < 200; g++) {
				String gval = g + "";
				games.add(gval);
			}

		});
		System.out.println(bos);
		System.out.println(buf);
		System.out.println(det);

	}

}
