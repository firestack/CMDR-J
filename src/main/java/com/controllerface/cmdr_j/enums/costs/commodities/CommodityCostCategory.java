package com.controllerface.cmdr_j.enums.costs.commodities;

import com.controllerface.cmdr_j.classes.tasks.TaskCost;
import com.controllerface.cmdr_j.classes.tasks.TaskCostCategory;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Controllerface on 4/11/2018.
 */
public enum CommodityCostCategory implements TaskCostCategory
{
    Drones(EnumSet.of(Commodity.DRONES)),

    Chemicals(EnumSet.of(Commodity.EXPLOSIVES,
            Commodity.HYDROGENFUEL,
            Commodity.HYDROGENPEROXIDE,
            Commodity.LIQUIDOXYGEN,
            Commodity.MINERALOIL,
            Commodity.NERVEAGENTS,
            Commodity.PESTICIDES,
            Commodity.SURFACESTABILISERS,
            Commodity.SYNTHETICREAGENTS,
            Commodity.WATER,
            Commodity.DELTAPHOENICISPALMS,
            Commodity.HIPORGANOPHOSPHATES,
            Commodity.KORROKUNGPELLETS,
            Commodity.MEDBSTARLUBE,
            Commodity.TOXANDJIVIROCIDE)),

    Consumer_Items(EnumSet.of(Commodity.CLOTHING,
            Commodity.CONSUMERTECHNOLOGY,
            Commodity.DOMESTICAPPLIANCES,
            Commodity.EVACUATIONSHELTER,
            Commodity.SURVIVALEQUIPMENT,
            Commodity.ALACARAKMOSKINART,
            Commodity.ALTAIRIANSKIN,
            Commodity.ANDULIGAFIREWORKS,
            Commodity.BUCKYBALLBEERMATS,
            Commodity.CRYSTALLINESPHERES,
            Commodity.ELEUTHERMALS,
            Commodity.ESHUUMBRELLAS,
            Commodity.HAVASUPAIDREAMCATCHER,
            Commodity.JAQUESQUINENTIANSTILL,
            Commodity.JARADHARREPUZZLEBOX,
            Commodity.KARETIICOUTURE,
            Commodity.KINAGOINSTRUMENTS,
            Commodity.ALIENEGGS,
            Commodity.MOMUSBOGSPANIEL,
            Commodity.NGUNAMODERNANTIQUES,
            Commodity.NJANGARISADDLES,
            Commodity.OPHIUCHIEXINOARTEFACTS,
            Commodity.RAJUKRUSTOVES,
            Commodity.SHANSCHARISORCHID,
            Commodity.SOONTILLRELICS,
            Commodity.TAURICHIMES,
            Commodity.THEHUTTONMUG,
            Commodity.TIOLCEWASTE2PASTEUNITS,
            Commodity.ADVERT1,
            Commodity.UZUMOKULOWGWINGS,
            Commodity.VIDAVANTIANLACE,
            Commodity.ZEESSZEANTGLUE)),

    Foods(EnumSet.of(Commodity.ALGAE,
            Commodity.ANIMALMEAT,
            Commodity.COFFEE,
            Commodity.FISH,
            Commodity.FOODCARTRIDGES,
            Commodity.FRUITANDVEGETABLES,
            Commodity.GRAIN,
            Commodity.SYNTHETICMEAT,
            Commodity.TEA,
            Commodity.CETIAEPYORNISEGG,
            Commodity.ALBINOQUECHUAMAMMOTH,
            Commodity.ANYNACOFFEE,
            Commodity.AROUCACONVENTUALSWEETS,
            Commodity.BLUEMILK,
            Commodity.BALTAHSINEVACUUMKRILL,
            Commodity.CD75CATCOFFEE,
            Commodity.CEREMONIALHEIKETEA,
            Commodity.CETIRABBITS,
            Commodity.CHIERIDANIMARINEPASTE,
            Commodity.COQUIMSPONGIFORMVICTUALS,
            Commodity.DEURINGASTRUFFLES,
            Commodity.DISOMACORN,
            Commodity.AERIALEDENAPPLE,
            Commodity.ESUSEKUCAVIAR,
            Commodity.FUJINTEA,
            Commodity.GIANTIRUKAMASNAILS,
            Commodity.GOMANYAUPONCOFFEE,
            Commodity.HAIDNEBLACKBREW,
            Commodity.HIP10175BUSHMEAT,
            Commodity.HIP41181SQUID,
            Commodity.HR7221WHEAT,
            Commodity.JAROUARICE,
            Commodity.KARSUKILOCUSTS,
            Commodity.LIVEHECATESEAWORMS,
            Commodity.LTTHYPERSWEET,
            Commodity.MECHUCOSHIGHTEA,
            Commodity.MOKOJINGBEASTFEAST,
            Commodity.MUKUSUBIICHITINOS,
            Commodity.MULACHIGIANTFUNGUS,
            Commodity.NERITUSBERRIES,
            Commodity.OCHOENGCHILLIES,
            Commodity.ORRERIANVICIOUSBREW,
            Commodity.SANUMAMEAT,
            Commodity.TANMARKTRANQUILTEA,
            Commodity.USZAIANTREEGRUB,
            Commodity.UTGAROARMILLENIALEGGS,
            Commodity.LFTVOIDEXTRACTCOFFEE,
            Commodity.WHEEMETEWHEATCAKES,
            Commodity.WITCHHAULKOBEBEEF,
            Commodity.ETHGREZETEABUDS)),

    Industrial_Materials(EnumSet.of(Commodity.CERAMICCOMPOSITES,
            Commodity.CMMCOMPOSITE,
            Commodity.INSULATINGMEMBRANE,
            Commodity.METAALLOYS,
            Commodity.COOLINGHOSES,
            Commodity.NEOFABRICINSULATION,
            Commodity.POLYMERS,
            Commodity.SEMICONDUCTORS,
            Commodity.SUPERCONDUCTORS)),

    Legal_Drugs(EnumSet.of(Commodity.BEER,
            Commodity.BOOTLEGLIQUOR,
            Commodity.LIQUOR,
            Commodity.BASICNARCOTICS,
            Commodity.TOBACCO,
            Commodity.WINE,
            Commodity.BASTSNAKEGIN,
            Commodity.BURNHAMBILEDISTILLATE,
            Commodity.CENTAURIMEGAGIN,
            Commodity.CHATEAUDEAEGAEON,
            Commodity.ANIMALEFFIGIES,
            Commodity.ERANINPEARLWHISKY,
            Commodity.GEAWENDANCEDUST,
            Commodity.GERASIANGUEUZEBEER,
            Commodity.HARMASILVERSEARUM,
            Commodity.INDIBOURBON,
            Commodity.KAMITRACIGARS,
            Commodity.KONGGAALE,
            Commodity.LAVIANBRANDY,
            Commodity.LEESTIANEVILJUICE,
            Commodity.TRANSGENICONIONHEAD,
            Commodity.LYRAEWEED,
            Commodity.MOTRONAEXPERIENCEJELLY,
            Commodity.ONIONHEAD,
            Commodity.ONIONHEADA,
            Commodity.ONIONHEADB,
            Commodity.PAVONISEARGRUBS,
            Commodity.RUSANIOLDSMOKEY,
            Commodity.SAXONWINE,
            Commodity.TARACHTORSPICE,
            Commodity.THRUTISCREAM,
            Commodity.WOLF1301FESH,
            Commodity.WUTHIELOKUFROTH,
            Commodity.YASOKONDILEAF)),

    Machinery(EnumSet.of(Commodity.ARTICULATIONMOTORS,
            Commodity.ATMOSPHERICEXTRACTORS,
            Commodity.BUILDINGFABRICATORS,
            Commodity.CROPHARVESTERS,
            Commodity.EMERGENCYPOWERCELLS,
            Commodity.POWERGRIDASSEMBLY,
            Commodity.EXHAUSTMANIFOLD,
            Commodity.GEOLOGICALEQUIPMENT,
            Commodity.HEATSINKINTERLINK,
            Commodity.HNSHOCKMOUNT,
            Commodity.MAGNETICEMITTERCOIL,
            Commodity.MARINESUPPLIES,
            Commodity.HELIOSTATICFURNACES,
            Commodity.MINERALEXTRACTORS,
            Commodity.MODULARTERMINALS,
            Commodity.POWERCONVERTER,
            Commodity.POWERGENERATORS,
            Commodity.POWERTRANSFERCONDUITS,
            Commodity.RADIATIONBAFFLE,
            Commodity.REINFORCEDMOUNTINGPLATE,
            Commodity.SKIMERCOMPONENTS,
            Commodity.THERMALCOOLINGUNITS,
            Commodity.WATERPURIFIERS,
            Commodity.GIANTVERRIX,
            Commodity.NONEUCLIDIANEXOTANKS,
            Commodity.VOLKHABBEEDRONES,
            Commodity.WULPAHYPERBORESYSTEMS)),

    Medicines(EnumSet.of(Commodity.ADVANCEDMEDICINES,
            Commodity.AGRICULTURALMEDICINES,
            Commodity.BASICMEDICINES,
            Commodity.COMBATSTABILISERS,
            Commodity.PERFORMANCEENHANCERS,
            Commodity.PROGENITORCELLS,
            Commodity.AGANIPPERUSH,
            Commodity.ALYABODILYSOAP,
            Commodity.HONESTYPILLS,
            Commodity.KACHIRIGINLEACHES,
            Commodity.PANTAAPRAYERSTICKS,
            Commodity.TERRAMATERBLOODBORES,
            Commodity.VHERCULISBODYRUB,
            Commodity.VEGASLIMWEED,
            Commodity.WATERSOFSHINTARA)),

    Metals(EnumSet.of(Commodity.ALUMINIUM,
            Commodity.BERYLLIUM,
            Commodity.BISMUTH,
            Commodity.COBALT,
            Commodity.COPPER,
            Commodity.GALLIUM,
            Commodity.GOLD,
            Commodity.HAFNIUM178,
            Commodity.INDIUM,
            Commodity.LANTHANUM,
            Commodity.LITHIUM,
            Commodity.OSMIUM,
            Commodity.PALLADIUM,
            Commodity.PLATINUM,
            Commodity.PLATINUMALOY,
            Commodity.PRASEODYMIUM,
            Commodity.SAMARIUM,
            Commodity.SILVER,
            Commodity.TANTALUM,
            Commodity.THALLIUM,
            Commodity.THORIUM,
            Commodity.TITANIUM,
            Commodity.URANIUM,
            Commodity.CHERBONESBLOODCRYSTALS,
            Commodity.HELVETITJPEARLS,
            Commodity.NGADANDARIFIREOPALS,
            Commodity.SOTHISCRYSTALLINEGOLD)),

    Minerals(EnumSet.of(Commodity.BAUXITE,
            Commodity.BERTRANDITE,
            Commodity.BROMELLITE,
            Commodity.COLTAN,
            Commodity.CRYOLITE,
            Commodity.GALLITE,
            Commodity.GOSLARITE,
            Commodity.INDITE,
            Commodity.JADEITE,
            Commodity.LEPIDOLITE,
            Commodity.LITHIUMHYDROXIDE,
            Commodity.LOWTEMPERATUREDIAMOND,
            Commodity.METHANECLATHRATE,
            Commodity.METHANOLMONOHYDRATECRYSTALS,
            Commodity.MOISSANITE,
            Commodity.PAINITE,
            Commodity.PYROPHYLLITE,
            Commodity.RUTILE,
            Commodity.TAAFFEITE,
            Commodity.URANINITE,
            Commodity.RHODPLUMSITE,
            Commodity.SERENDIBITE,
            Commodity.MONAZITE,
            Commodity.MUSGRAVITE,
            Commodity.BENITOITE,
            Commodity.GRANDIDIERITE,
            Commodity.ALEXANDRITE,
            Commodity.OPAL)),

    Salvage(EnumSet.of(Commodity.AIRELICS,
            Commodity.USSCARGOANCIENTARTEFACT,
            Commodity.ANCIENTCASKET,
            Commodity.ANCIENTORB,
            Commodity.ANCIENTRELIC,
            Commodity.ANCIENTTABLET,
            Commodity.ANCIENTTOTEM,
            Commodity.ANCIENTURN,
            Commodity.ANTIMATTERCONTAINMENTUNIT,
            Commodity.ANTIQUEJEWELLERY,
            Commodity.ANTIQUITIES,
            Commodity.ASSAULTPLANS,
            Commodity.USSCARGOBLACKBOX,
            Commodity.COMERCIALSAMPLES,
            Commodity.DAMAGEDESCAPEPOD,
            Commodity.DATACORE,
            Commodity.DIPLOMATICBAG,
            Commodity.EARTHRELICS,
            Commodity.ENCRYPTEDCORRESPONDENCE,
            Commodity.ENCRIPTEDDATASTORAGE,
            Commodity.USSCARGOEXPERIMENTALCHEMICALS,
            Commodity.FOSSILREMNANTS,
            Commodity.GENEBANK,
            Commodity.GEOLOGICALSAMPLES,
            Commodity.HOSTAGE,
            Commodity.LARGEEXPLORATIONDATACASH,
            Commodity.MILITARYINTELLIGENCE,
            Commodity.USSCARGOMILITARYPLANS,
            Commodity.MYSTERIOUSIDOL,
            Commodity.OCCUPIEDESCAPEPOD,
            Commodity.PERSONALEFFECTS,
            Commodity.POLITICALPRISONER,
            Commodity.PRECIOUSGEMS,
            Commodity.PROHIBITEDRESEARCHMATERIALS,
            Commodity.USSCARGOPROTOTYPETECH,
            Commodity.USSCARGORAREARTWORK,
            Commodity.USSCARGOREBELTRANSMISSIONS,
            Commodity.SAP8CORECONTAINER,
            Commodity.SCIENTIFICRESEARCH,
            Commodity.SCIENTIFICSAMPLES,
            Commodity.SMALLEXPLORATIONDATACASH,
            Commodity.SPACEPIONEERRELICS,
            Commodity.TACTICALDATA,
            Commodity.USSCARGOTECHNICALBLUEPRINTS,
            Commodity.THARGOIDBASILISKTISSUESAMPLE,
            Commodity.THARGOIDBIOLOGICALMATTER,
            Commodity.THARGOIDCYCLOPSTISSUESAMPLE,
            Commodity.THARGOIDHEART,
            Commodity.THARGOIDLINK,
            Commodity.THARGOIDMEDUSATISSUESAMPLE,
            Commodity.THARGOIDPROBE,
            Commodity.THARGOIDRESIN,
            Commodity.THARGOIDSCOUTTISSUESAMPLE,
            Commodity.THARGOIDSENSOR,
            Commodity.THARGOIDTECHNOLOGYSAMPLES,
            Commodity.TIMECAPSULE,
            Commodity.USSCARGOTRADEDATA,
            Commodity.TRINKETSOFHIDDENFORTUNE,
            Commodity.UNSTABLEDATACORE,
            Commodity.WRECKAGECOMPONENTS,
            Commodity.GALACTICTRAVELGUIDE,
            Commodity.PERSONALGIFTS)),

    Slaves(EnumSet.of(Commodity.IMPERIALSLAVES,
            Commodity.SLAVES,
            Commodity.MASTERCHEFS)),

    Technology(EnumSet.of(Commodity.ADVANCEDCATALYSERS,
            Commodity.ANIMALMONITORS,
            Commodity.AQUAPONICSYSTEMS,
            Commodity.AUTOFABRICATORS,
            Commodity.BIOREDUCINGLICHEN,
            Commodity.COMPUTERCOMPONENTS,
            Commodity.HAZARDOUSENVIRONMENTSUITS,
            Commodity.DIAGNOSTICSENSOR,
            Commodity.IONDISTRIBUTOR,
            Commodity.TERRAINENRICHMENTSYSTEMS,
            Commodity.MEDICALDIAGNOSTICEQUIPMENT,
            Commodity.MICROCONTROLLERS,
            Commodity.MUONIMAGER,
            Commodity.NANOBREAKERS,
            Commodity.RESONATINGSEPARATORS,
            Commodity.ROBOTICS,
            Commodity.STRUCTURALREGULATORS,
            Commodity.TELEMETRYSUITE,
            Commodity.AZCANCRIFORMULA42,
            Commodity.XIHECOMPANIONS)),

    Textiles(EnumSet.of(Commodity.CONDUCTIVEFABRICS,
            Commodity.LEATHER,
            Commodity.MILITARYGRADEFABRICS,
            Commodity.NATURALFABRICS,
            Commodity.SYNTHETICFABRICS,
            Commodity.BANKIAMPHIBIOUSLEATHER,
            Commodity.BELALANSRAYLEATHER,
            Commodity.CHAMELEONCLOTH,
            Commodity.DAMNACARAPACES,
            Commodity.JOTUNMOOKAH,
            Commodity.RAPABAOSNAKESKINS,
            Commodity.VANAYEQUIRHINOFUR)),

    Waste(EnumSet.of(Commodity.BIOWASTE,
            Commodity.CHEMICALWASTE,
            Commodity.SCRAP,
            Commodity.TOXICWASTE)),

    Weapons(EnumSet.of(Commodity.BATTLEWEAPONS,
            Commodity.LANDMINES,
            Commodity.NONLETHALWEAPONS,
            Commodity.PERSONALWEAPONS,
            Commodity.REACTIVEARMOUR,
            Commodity.BORASETANIPATHOGENETICS,
            Commodity.GILYASIGNATUREWEAPONS,
            Commodity.HIP118311SWARM,
            Commodity.HOLVADUELLINGBLADES,
            Commodity.KAMORINHISTORICWEAPONS)),



    Power_Play(EnumSet.of(Commodity.AISLINGMEDIAMATERIALS,
            Commodity.AISLINGMEDIARESOURCES,
            Commodity.AISLINGPROMOTIONALMATERIALS,
            Commodity.ALLIANCETRADEAGREEMENTS,
            Commodity.ALLIANCELEGASLATIVECONTRACTS,
            Commodity.ALLIANCELEGASLATIVERECORDS,
            Commodity.LAVIGNYCORRUPTIONDOSSIERS,
            Commodity.LAVIGNYFIELDSUPPLIES,
            Commodity.LAVIGNYGARISONSUPPLIES,
            Commodity.RESTRICTEDPACKAGE,
            Commodity.LIBERALCAMPAIGNMATERIALS,
            Commodity.FEDERALAID,
            Commodity.FEDERALTRADECONTRACTS,
            Commodity.LOANEDARMS,
            Commodity.PATREUSFIELDSUPPLIES,
            Commodity.PATREUSGARISONSUPPLIES,
            Commodity.RESTRICTEDINTEL,
            Commodity.REPUBLICANFIELDSUPPLIES,
            Commodity.REPUBLICANGARISONSUPPLIES,
            Commodity.SIRIUSFRANCHISEPACKAGE,
            Commodity.SIRIUSCOMMERCIALCONTRACTS,
            Commodity.SIRIUSINDUSTRIALEQUIPMENT,
            Commodity.TORVALCOMMERCIALCONTRACTS,
            Commodity.IMPERIALPRISONER,
            Commodity.UTOPIANPUBLICITY,
            Commodity.UTOPIANFIELDSUPPLIES,
            Commodity.UTOPIANDISSIDENT,
            Commodity.ILLICITCONSIGNMENT,
            Commodity.UNMARKEDWEAPONS,
            Commodity.ONIONHEADSAMPLES,
            Commodity.COUNTERCULTURESUPPORT,
            Commodity.MARKEDSLAVES,
            Commodity.TORVALDEEDS,
            Commodity.ONIONHEADDERIVATIVES,
            Commodity.OUTOFDATEGOODS,
            Commodity.UNDERGROUNDSUPPORT,
            Commodity.GROMCOUNTERINTELLIGENCE,
            Commodity.GROMWARTROPHIES)),

    ;

    private final EnumSet<Commodity> commodities;

    CommodityCostCategory(EnumSet<Commodity> commodities)
    {
        this.commodities = commodities;
    }

    public boolean hasCommodity(Commodity commodity)
    {
        return commodities.contains(commodity);
    }

    public static Optional<CommodityCostCategory> findMatchingCategory(TaskCost cost)
    {
        if (!(cost instanceof Commodity)) return Optional.empty();
        Commodity commodity = ((Commodity) cost);
        return Arrays.stream(values())
                .filter(category->category.hasCommodity(commodity))
                .findFirst();
    }
    public Stream<Commodity> commodities()
    {
        return commodities.stream();
    }

    @Override
    public int getNumericalValue()
    {
        return this.ordinal();
    }

    @Override
    public String toString()
    {
        return super.toString().replace("_", " ");
    }
}
