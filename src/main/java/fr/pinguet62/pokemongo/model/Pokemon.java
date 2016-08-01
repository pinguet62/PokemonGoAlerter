package fr.pinguet62.pokemongo.model;

import static fr.pinguet62.pokemongo.model.Importance.HIGH;
import static fr.pinguet62.pokemongo.model.Importance.LOW;
import static fr.pinguet62.pokemongo.model.Importance.MEDIUM;

public enum Pokemon {
 
	BULBIZARRE(1, "Bulbizarre", HIGH),
	HERBIZARRE(2, "Herbizarre", HIGH),
	FLORIZARRE(3, "Florizarre", HIGH),
	SALAMECHE(4, "Salamèche", HIGH),
	REPTINCEL(5, "Reptincel", HIGH),
	DRACAUFEU(6, "Dracaufeu", HIGH),
	CARAPUCE(7, "Carapuce", HIGH),
	CARABAFFE(8, "Carabaffe", HIGH),
	TORTANK(9, "Tortank", HIGH),
	CHENIPAN(10, "Chenipan", LOW),
	CHRYSACIER(11, "Chrysacier", LOW),
	PAPILUSION(12, "Papilusion", LOW),
	ASPICOT(13, "Aspicot", LOW),
	COCONFORT(14, "Coconfort", LOW),
	DARDARGNAN(15, "Dardargnan", LOW),
	ROUCOOL(16, "Roucool", LOW),
	ROUCOUPS(17, "Roucoups", LOW),
	ROUCARNAGE(18, "Roucarnage", LOW),
	RATTATA(19, "Rattata", LOW),
	RATTATAC(20, "Rattatac", LOW),
	PIAFABEC(21, "Piafabec", LOW),
	RAPASDEPIC(22, "Rapasdepic", LOW),
	ABO(23, "Abo", HIGH),
	ARBOK(24, "Arbok", HIGH),
	PIKACHU(25, "Pikachu", HIGH),
	RAICHU(26, "Raichu", HIGH),
	SABELETTE(27, "Sabelette", HIGH),
	SABLAIREAU(28, "Sablaireau", HIGH),
	NIDORAN_FEMELLE(29, "Nidoran♀", HIGH),
	NIDORINA(30, "Nidorina", HIGH),
	NIDOQUEEN(31, "Nidoqueen", HIGH),
	NIDORAN_MALE(32, "Nidoran♂", HIGH),
	NIDORINO(33, "Nidorino", HIGH),
	NIDOKING(34, "Nidoking", HIGH),
	MELOFEE(35, "Mélofée", MEDIUM),
	MELODELFE(36, "Mélodelfe", HIGH),
	GOUPIX(37, "Goupix", HIGH),
	FEUNARD(38, "Feunard", HIGH),
	RONDOUDOU(39, "Rondoudou", MEDIUM),
	GRODOUDOU(40, "Grodoudou", HIGH),
	NOSFERAPTI(41, "Nosferapti", LOW),
	NOSFERALTO(42, "Nosferalto", LOW),
	MYSTHERBE(43, "Mystherbe", HIGH),
	ORTIDE(44, "Ortide", HIGH),
	RAFFLESIA(45, "Rafflesia", HIGH),
	PARAS(46, "Paras", LOW),
	PARASECT(47, "Parasect", MEDIUM),
	MIMITOSS(48, "Mimitoss", LOW),
	AEROMITE(49, "Aéromite", MEDIUM),
	TAUPIQUEUR(50, "Taupiqueur", HIGH),
	TRIOPIKEUR(51, "Triopikeur", HIGH),
	MIAOUSS(52, "Miaouss", MEDIUM),
	PERSIAN(53, "Persian", HIGH),
	PSYKOKWAK(54, "Psykokwak", LOW),
	AKWAKWAK(55, "Akwakwak", MEDIUM),
	FEROSINGE(56, "Férosinge", HIGH),
	COLOSSINGE(57, "Colossinge", HIGH),
	CANINOS(58, "Caninos", HIGH),
	ARCANIN(59, "Arcanin", HIGH),
	PTITARD(60, "Ptitard", LOW),
	TETARTE(61, "Têtarte", LOW),
	TARTARD(62, "Tartard", LOW),
	ABRA(63, "Abra", HIGH),
	KADABRA(64, "Kadabra", HIGH),
	ALAKAZAM(65, "Alakazam", HIGH),
	MACHOC(66, "Machoc", HIGH),
	MACHOPEUR(67, "Machopeur", HIGH),
	MACKOGNEUR(68, "Mackogneur", HIGH),
	CHETIFLOR(69, "Chétiflor", HIGH),
	BOUSTIFLOR(70, "Boustiflor", HIGH),
	EMPIFLOR(71, "Empiflor", HIGH),
	TENTACOOL(72, "Tentacool", MEDIUM),
	TENTACRUEL(73, "Tentacruel", HIGH),
	RACAILLOU(74, "Racaillou", HIGH),
	GRAVALANCH(75, "Gravalanch", HIGH),
	GROLEM(76, "Grolem", HIGH),
	PONYTA(77, "Ponyta", HIGH),
	GALOPA(78, "Galopa", HIGH),
	RAMOLOSS(79, "Ramoloss", LOW),
	FLAGADOSS(80, "Flagadoss", LOW),
	MAGNETI(81, "Magnéti", MEDIUM),
	MAGNETON(82, "Magnéton", MEDIUM),
	CANARTICHO(83, "Canarticho", HIGH),
	DODUO(84, "Doduo", HIGH),
	DODRIO(85, "Dodrio", HIGH),
	OTARIA(86, "Otaria", MEDIUM),
	LAMANTINE(87, "Lamantine", MEDIUM),
	TADMORV(88, "Tadmorv", HIGH),
	GROTADMORV(89, "Grotadmorv", HIGH),
	KOKIYAS(90, "Kokiyas", LOW),
	CRUSTABRI(91, "Crustabri", LOW),
	FANTOMINUS(92, "Fantominus", MEDIUM),
	SPECTRUM(93, "Spectrum", MEDIUM),
	ECTOPLASMA(94, "Ectoplasma", MEDIUM),
	ONIX(95, "Onix", HIGH),
	SOPORIFIK(96, "Soporifik", LOW),
	HYPNOMADE(97, "Hypnomade", LOW),
	KRABBY(98, "Krabby", LOW),
	KRABBOSS(99, "Krabboss", LOW),
	VOLTORBE(100, "Voltorbe", LOW),
	ELECTRODE(101, "Électrode", LOW),
	NOEUNOEUF(102, "Noeunoeuf", MEDIUM),
	NOADKOKO(103, "Noadkoko", MEDIUM),
	OSSELAIT(104, "Osselait", HIGH),
	OSSATUEUR(105, "Ossatueur", HIGH),
	KICKLEE(106, "Kicklee", MEDIUM),
	TYGNON(107, "Tygnon", MEDIUM),
	EXCELANGUE(108, "Excelangue", HIGH),
	SMOGO(109, "Smogo", MEDIUM),
	SMOGOGO(110, "Smogogo", MEDIUM),
	RHINOCORNE(111, "Rhinocorne", HIGH),
	RHINOFEROS(112, "Rhinoféros", HIGH),
	LEVEINARD(113, "Leveinard", HIGH),
	SAQUEDENEU(114, "Saquedeneu", HIGH),
	KANGOUREX(115, "Kangourex", HIGH),
	HYPOTREMPE(116, "Hypotrempe", MEDIUM),
	HYPOCEAN(117, "Hypocéan", MEDIUM),
	POISSIRENE(118, "Poissirène", LOW),
	POISSOROY(119, "Poissoroy", LOW),
	STARI(120, "Stari", LOW),
	STAROSS(121, "Staross", LOW),
	M_MIME(122, "M.Mime", MEDIUM),
	INSECATEUR(123, "Insécateur", HIGH),
	LIPPOUTOU(124, "Lippoutou", HIGH),
	ELEKTEK(125, "Élektek", HIGH),
	MAGMAR(126, "Magmar", HIGH),
	SCARABRUTE(127, "Scarabrute", MEDIUM),
	TAUROS(128, "Tauros", HIGH),
	MAGICARPE(129, "Magicarpe", LOW),
	LEVIATOR(130, "Léviator", HIGH),
	LOKHLASS(131, "Lokhlass", HIGH),
	METAMORPH(132, "Métamorph", HIGH),
	EVOLI(133, "Évoli", HIGH),
	AQUALI(134, "Aquali", HIGH),
	VOLTALI(135, "Voltali", HIGH),
	PYROLI(136, "Pyroli", HIGH),
	PORYGON(137, "Porygon", HIGH),
	AMONITA(138, "Amonita", HIGH),
	AMONISTAR(139, "Amonistar", HIGH),
	KABUTO(140, "Kabuto", HIGH),
	KABUTOPS(141, "Kabutops", HIGH),
	PTERA(142, "Ptéra", HIGH),
	RONFLEX(143, "Ronflex", HIGH),
	ARTIKODIN(144, "Artikodin", HIGH),
	ELECTHOR(145, "Électhor", HIGH),
	SULFURA(146, "Sulfura", HIGH),
	MINIDRACO(147, "Minidraco", HIGH),
	DRACO(148, "Draco", HIGH),
	DRACOLOSSE(149, "Dracolosse", HIGH),
	MEWTWO(150, "Mewtwo", HIGH),
	MEW(151, "Mew", HIGH);

	/**
	 * @param id
	 *            The {@link #id}.
	 * @return The {@link Pokemon}.
	 * @throws IllegalArgumentException
	 *             Unknown {@link #id}.
	 */
	public static Pokemon fromId(int id) {
		for (Pokemon pokemon : values())
			if (pokemon.id == id)
				return pokemon;
		throw new IllegalArgumentException("Unknown id " + id);
	}

	private final int id;

	private final String name;

	private final Importance importance;

	private Pokemon(int id, String name, Importance importance) {
		this.id = id;
		this.name = name;
		this.importance = importance;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Importance getImportance() {
		return importance;
	}

	@Override
	public String toString() {
		return "#" + id + ": " + name;
	}

}