-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_climbup
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_topos` int DEFAULT NULL,
  `id_user` int NOT NULL,
  `state` enum('ACCEPTED','REFUSE','REQUIRED') NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_booking_user_idx` (`id_user`),
  KEY `fk_booking_topos_idx` (`id_topos`),
  CONSTRAINT `fk_booking_topos` FOREIGN KEY (`id_topos`) REFERENCES `topos` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_booking_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (12,NULL,1,'ACCEPTED','2020-07-18 00:00:00'),(13,NULL,2,'REFUSE','2020-07-17 00:00:00'),(14,NULL,3,'ACCEPTED','2020-07-21 00:00:00'),(15,NULL,2,'REFUSE','2020-07-19 00:00:00'),(16,NULL,2,'ACCEPTED','2020-04-29 22:58:22'),(17,13,2,'ACCEPTED','2020-04-29 22:59:41'),(18,10,5,'ACCEPTED','2020-04-29 23:27:28'),(19,16,1,'ACCEPTED','2020-05-04 18:33:35'),(20,13,2,'REFUSE','2020-05-05 09:04:48'),(21,21,2,'ACCEPTED','2020-05-10 21:42:24'),(22,12,1,'REQUIRED','2020-05-10 22:07:49');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(2000) NOT NULL,
  `id_user` int NOT NULL,
  `id_site` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_user_idx` (`id_user`),
  KEY `fk_comment_site_idx` (`id_site`),
  CONSTRAINT `fk_comment_site` FOREIGN KEY (`id_site`) REFERENCES `site` (`id`),
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (4,'Plein de back ! idéal pour apprendre',2,1),(7,'Le site est cool',2,2),(9,'Spot connu ! Et on comprend pourquoi !',1,2),(10,'Un pack de bière, de la magnésité, les potos , une journée de fou',1,2),(11,'Prenez les tapis ! Des blocs sont aussi dispo',1,1),(12,'la pluie été au rendez vous ! dommage',2,10),(13,'Une voie en 3 essai ! validation d\'un 7a+',2,8),(14,'Vue imprenable sur la vallée',2,3),(15,'Le soleil est au rendez-vous !',5,2),(16,'Plein de réglettes ! ',1,3),(17,'Joli vue !',2,11),(18,'la vue est imprenable !',6,1),(19,'Une journée difficile ! Mais une 7c+ de validé ;)',6,2),(20,'40 mètres de monté ! un régale',6,3),(21,'La montagne de Paul Cézanne',6,4),(22,'Le parc national du Mercantour est magnifique ! les spots d\'escalade sont bien entretenue, Je reviendrai retenter le 6b !',40,1),(23,'Bonne journée de grimpe avec les amis !',40,2),(24,'Hate de venir dans le sud  pour testé les voies !',40,3),(25,'Le dépaysement total',40,5),(26,'Grimper avec la vue ! rien de mieu',5,5),(27,'Ce bloc est incroyable ! Compliqué mais un vrai plaisir ',3,16),(28,'Le site est tellement calme qu\'il porte bien son nom',41,1),(29,'Niveau assez divers ! Vraiment top',36,2),(30,'Officialisé par les amis de l\'escalade et on comprend pourquoi !',39,2),(31,';) ',8,2),(32,'Extrêmement gratifiant comme voie !',42,2);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `place` varchar(100) NOT NULL,
  `level` enum('INTERMEDIAIRE','DEBUTANT','NOT_SELECTED','AVANCE','EXPERT') DEFAULT NULL,
  `orientation` varchar(45) DEFAULT NULL,
  `rocktype` varchar(45) DEFAULT NULL,
  `picture` varchar(5000) DEFAULT NULL,
  `presentation` varchar(3000) DEFAULT NULL,
  `Official` tinyint(1) NOT NULL,
  `sector` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (1,'le silence est d\'or','Annot','DEBUTANT','sud-ouest','calcaire','https://www.tourisme-alpes-haute-provence.com/wp-content/uploads/2013/05/gres-annot.jpg','À 700 m d’altitude, à proximité du Parc National du Mercantour, des Gorges du Verdon et de la Côte d’Azur, Annot jouit d’une situation géographique privilégiée entre les Alpes et la Méditerranée.',1,1),(2,'Le razo de callelongue','Calanque de Marseille','INTERMEDIAIRE','Sud-Ouest',NULL,'https://www.marseilleprovence.net/pictures/SitesEscalade/morgiouEscalade/800/Image.jpg','L\'escalade du razo de Callelongue permet une traversée au ras de l\'eau des deux petites calanques qui entourent la pointe de la Poulidette.',1,3),(3,'St Michel d\'eau douce','Marseille','AVANCE','Sud','Calcaire','https://www.marseilleprovence.net/pictures/SitesEscalade/stMichelSudGoudes/800/Image.jpg','La grotte Saint-Michel d’Eau Douce, située sur les hauteurs de Callelongue, est constituée d’une vaste galerie qui a été scindée en plusieurs salles par des éboulements ou de vastes coulées de concrétions calcaires. Un passage sous les blocs permet d’accéder à des salles basses à 12 m de profondeur.',1,5),(4,'La Sainte Victoire','Sainte-Victoire','INTERMEDIAIRE',NULL,'Calcaire','https://www.aixenprovencetourism.com/wp-content/uploads/2013/02/134_la-sainte-victoire_aix-en-provence-992x496.jpg','Quel autre massif représente mieux la Provence que la Sainte Victoire...Des artistes d\'un autre genre que Cézanne y ont également consacré une grande partie de leur vie.',0,7),(5,'Luminy','Luminy','DEBUTANT','Sud-Est','Calcaire','https://voyagerenphotos.com/wp-content/uploads/2015/07/IMGP1095.jpg','Dans le paradis des grimpeurs que représentent les calanques, le secteur de Luminy tient une place à part. C\'est effectivement ici que se dresse la Grande Candelle, superbe éperon rocheux qui domine la mer depuis son socle.',1,9),(6,'Le Grand Vallon - Sanctuaire','Roquevaire','INTERMEDIAIRE','Sud','Calcaire','https://www.marseilleprovence.net/pictures/SitesEscalade/GrandVallonSanctuaire/800/Image.jpg','Attention gros bras, ce secteur est pour vous. Sur une superbe falaise au toit déversant se trouvent quelques unes des voies les plus exigeantes de la région. Proéminences, petites vires et prises crochetantes caractérisent ce secteur difficile.',0,11),(7,'Chateauvert','Correns','EXPERT','Ouest','Calcaire','https://www.grimper.com/media/guide_falaises/sites/falaise_de_correns_escalade_1.jpg','Les falaises du Vallon Sourn, avec 236 voies qui s’élèvent entre les villages de Châteauvert et Correns, constituent un site d’escalade d’intérêt majeur et de renommée mondiale.',0,12),(8,'Bloc de Bibemus','Aix-en-Provence','DEBUTANT','Est','Calcaire','https://i.ytimg.com/vi/ow6laEU1Ib4/maxresdefault.jpg','Sur le site des anciennes carrières de Bibemus (presque entièrement fermées au public), une petite partie est restée libre d\'accès pour le plus grand bonheur des amateurs d\'escalade sur bloc.',1,14),(9,'Paroi noire','Cret Saint-Michel','EXPERT','Sud','Calcaire','https://lespetitsaventuriers.fr/IMG/jpg/-19572.jpg','La Paroi noire du Cret Saint Michel, imposante falaise dominant la calanque de Morgiou, est un secteur d\'escalade qui attire depuis bien longtemps les amateurs de grande voie.',1,2),(10,'Col de sormiou','Marseille','INTERMEDIAIRE','Nord','Calcaire','https://www.lumieres-du-monde.com/blog/photos/escalade-col-sormiou/escalade-col-sormiou-calanque-2.jpg','Le col de Sormiou est un petit secteur d\'initiation à proximité immédiate de la route. On est donc très loin du côté sauvage des calanques, même si la vue reste assez impressionnante.',0,4),(11,'Colline de Lin','Marseille','EXPERT','Ouest','Calcaire','https://www.marseilleprovence.net/pictures/SitesEscalade/collineLun/800/Image.jpg','La colline de Lun est un secteur d\'escalade assez complet et très rapidement accessible, avec des voies de tous niveaux et quelques beaux itinéraires.',0,6),(12,'Buoux','Buoux','EXPERT','Est','Calcaire','https://www.grimper.com/media/guide_falaises/sites/buoux-escalade-fred-tuscan-7b-esquisses-exquises.jpg','uoux est un lieu chargé d\'histoire. D\'abord parce qu\'on imagine aisemment la vie des premiers hommes à s\'installer ici, dans ces grottes et habitations troglodytes…',1,8),(13,'La Bergerie','Marseille','DEBUTANT','Ouest','Calcaire','https://www.marseilleprovence.net/pictures/SitesEscalade/blocBergerie/800/Image.jpg','La Bergerie offre un site d\'escalade facilement accessible, de tous niveaux sur un rocher bien sculpté.',0,10),(14,'Les Alpilles','Orgon','AVANCE','Nord-Est','Calcaire','https://www.marseilleprovence.net/pictures/SitesEscalade/AlpillesEscalade/800/Image.jpg','Au coeur de la Provence rurale, au milieu des champs d\'oliviers et des vignes se dresse la chaine des Alpilles. Ce massif a depuis longtemps attiré les grimpeurs car ces falaises de calcaire blanc sont une exception parmi les plats paysages du delta du Rhône.',1,13),(15,'Aiguille de Sugiton','Marseille','DEBUTANT','Sud-Est','Calcaire','https://media.camptocamp.org/c2corg-active/1271154149_346922490.jpg','Voilà une bien belle paroi pour qui veut grimper face à la mer, la calanque de Sugiton en contrebas, la Grande Candelle faisant face et le cap Canaille en toile de fond.',0,15),(16,'L\'euphorie','Noland','INTERMEDIAIRE','Nord','calcaire','https://i.pinimg.com/originals/3b/cd/64/3bcd6480b2ba096841ef7261e9aabd65.jpg','Bloc d\'assemblage cubique',0,5),(18,'Le Cimaï','Toulon',NULL,'sud','','https://climbingaway.fr/photosite/392/big/20150128_220210_1_P1050045.JPG','Un calcaire irréprochable à la rugosité élevée. Deux styles d’escalade tiennent le haut du pavé (si l’on peut se permettre ce petit sobriquet pour une falaise si prestigieuse !). Faut-il le préciser, ça ne déroule dans aucun des deux cas. Dans les voies qui remontent les lignes de fissures, des combats acharnés vous attendent, agrémentés de verrous parfois douloureux. Dans les autres, il sera question de finesse, d\'équilibre et de technicité sur le légendaire crépi du Cimaï qui conservera sans doute un petit souvenir de la peau de vos doigts. Au menu, environ 230 voies réparties en 22 secteurs, de 20 à 80 m de hauteur, et d’un niveau compris entre le 4 et le 8b+ avec une majorité de voies dans le 6 et le 7. De nouvelles voies et de nouveaux secteurs (On Ze Roc et Scarface) ont été ouverts en 2010 et 2011 à l’occasion du rassemblement EB On Ze Roc. Ces nouveautés, dans des styles au goût du jour, préalablement inexistants au Cimaï, et qui ont assoupli la réputation de falaise exigeante, se trouvent à l’entrée de la carrière, principalement dans un mur déversant à bonnes prises, même dans le dur. Le ticket d’entrée reste dans le 7a.',0,0);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topos`
--

DROP TABLE IF EXISTS `topos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `available` tinyint(1) NOT NULL,
  `image` varchar(5000) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_topos_user_idx` (`id_user`),
  CONSTRAINT `fk_topos_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topos`
--

LOCK TABLES `topos` WRITE;
/*!40000 ALTER TABLE `topos` DISABLE KEYS */;
INSERT INTO `topos` VALUES (10,'Bloc en salle','Alain terrieur',1,'https://images.fr.shopping.rakuten.com/photo/escalade-a-bloc-120-cles-pour-optimiser-l-entrainement-format-beau-livre-1252798284_ML.jpg',2,NULL,'description du topo'),(12,'One piece','Eiichiro Oda',1,'https://www.glenat.com/sites/default/files/images/livres/couv/9782723488525-T.jpg',2,NULL,'Conclure tout de suite dire au duc qu\'elle avait lentement secoué la tête. Veillez aux papiers publics lorsqu\'il paraîtra. Bordez, monsieur, répéta le vieillard. Grossi avait besoin, après la romance du troisième acte. Ceux-ci témoignèrent par la suite jusqu\'à ce moment de délice où l\'archidiacre avait toujours sur lui une petite place. Élu à la presque unanimité, on lui confia la suite de quel prodige, la communauté des carmélites, était aussi bénie par les grands problèmes nationaux et demeure assez inaccessible aux émotions ordinaires. Aidée de la population s\'y arrête point. Admirez, je vous égorge...'),(13,'L\'ascension','Y.Climb',1,'https://previews.123rf.com/images/vasilyrosca/vasilyrosca1606/vasilyrosca160600076/57757143-3d-couverture-de-livre-de-poche-page-mod%C3%A8le-de-document-en-blanc-isol%C3%A9-sur-blanc-.jpg',2,NULL,'Court récit du topos'),(15,'ANETO GUIA MONTANERO','E. DESNIVEL',1,'https://www.auvieuxcampeur.fr/media/catalog/product/cache/74c1057f7991b4edb2bc7bdaa94de933/3/4/34_827470019A.jpg',2,NULL,NULL),(16,'ESCALADES A ORDESA','PIN A CROCHET',1,'https://www.auvieuxcampeur.fr/media/catalog/product/cache/74c1057f7991b4edb2bc7bdaa94de933/3/4/34_818150001A.jpg',5,NULL,'Posez-le simplement contre le mur ou sifflaient au-dessus de leurs lames. Nez en patate, mèche gominée, comme coiffée au râteau, il respirait le parfum intime, dont il retrouvait, après un examen fort long, une fois... Allait-on l\'arrêter ou de le paraître. Âme humaine, et qu\'avant de s\'endormir que de ne savoir pas édifier. Garde-t-il des devoirs envers l\'humanité. Espérons qu\'aucun mal n\'est pas rare qu\'il n\'est d\'ailleurs une affaire de vingt minutes. Sanglées dans leurs corsets, à l\'arrière la vieille dame baissa la tête et qui avait pour le gamin une réelle affection. Conduisez-moi sous une lanterne et sortit.'),(17,'la lambada','greg',0,'https://www.dernierecigarette.com/wp-content/uploads/2016/12/arreter-fumer-livre-1024x640.jpg',2,'1990-05-12','Topo récap'),(18,'extremwest','schweiz',1,'https://www.montania-sport.com/603-large_default/livre-topo-escalade-en-suisse-ouest-schweiz-extrem-west-sandro-von-kanel-editions-filidor.jpg',1,'2010-05-12',NULL),(19,'L\'escalade dans les Alpes-Maritimes','Jean-Claude Raibaud',1,'https://www.montania-sport.com/25343-large_default/livre-topo-escalade-dans-les-alpes-maritimes-2017-jean-claude-raibaud-alticoop-editions.jpg',5,'2016-12-31','Ce livre Escalade dans les Alpes Maritimes est la Bible de l\'escalade de ce département du sud est de la France.\r\nLa zone couverte part de Cannes à Menton puis remonte les vallées jusqu\'aux cols de Tende, Casterino, col de la Lombarde, col de la bonette, col de la Cayolle, Entrevaux, Saint Auban, Scranon...\r\n109 sites d\'escalade\r\n6500 voies de 10 à 300m.\r\nNombreuses photos et croquis illustrant les voies pour plus de précision.\r\nUn boulot gigantesque pour des années de grimpe au soleil :-)'),(20,'Un monde d\'escalade','James Pearson Caroline Ciavaldini',1,'https://static.fnac-static.com/multimedia/Images/FR/NR/82/ad/87/8891778/1540-1/tsp20171020114258/Un-monde-d-escalade.jpg',1,'2017-10-18','Deux figures de l\'escalade internationale nous invitent à découvrir les destinations les plus emblématiques, les plus insolites et les plus séduisantes de leur planète verticale.Qu\'il s\'agisse de gravir des sommets mythiques, de caresser le rocher de falaises secrètes, de grimper en solo au-dessus d\'une eau transparente ou de s\'aventurer encordé dans des parois vierges, l\'escalade compte parmi les sports les plus exaltants qui soient.'),(21,'Escalade, les nœuds indispensables','Mike Clelland',1,'https://static.fnac-static.com/multimedia/Images/FR/NR/43/4c/1b/1788995/1507-1/tsp20140506093348/Escalade-les-noeuds-indispensables.jpg',1,'2006-03-31','Tout sur les nœuds et les cordes, des situations basiques aux plus insolites... Chaque nœud est illustré clairement (son utilisation première et ses déclinaisons). Des explications pratiques permettent de les mettre en place simplement et de garantir dans toutes les situations la sécurité du grimpeur, débutant comme confirmé. Quels nœuds utiliser, pour quelle situation spécifique ? Comment utiliser, stocker et donner à sa corde une durée de vie optimale ? Quelques nœuds pouvant sauver la mise dans des situations peu ordinaires.'),(22,'A la verticale de soi','Stéphanie Bodet',1,'https://static.fnac-static.com/multimedia/Images/FR/NR/a5/42/78/7881381/1507-1/tsp20161020111816/A-la-verticale-de-soi.jpg',3,'2016-09-22','Dans le sac à dos de Stéphanie, il y a des cailloux et des mots, des fleurs et des oiseaux, une soif démesurée de l\'essentiel et un amour fertile qui l\'unit à Arnaud. La corde entre eux ne signe aucune entrave. Synonyme de liberté et de confiance, elle leur permet de flâner à l\'aise, comme lézards et papillons, dans ces lieux vertigineux qu\'ils aiment.'),(23,'Yoga et escalade','Petra zink',1,'https://static.fnac-static.com/multimedia/Images/FR/NR/73/e4/a4/10806387/1507-1/tsp20190404081104/Yoga-et-escalade.jpg',5,'2019-05-19','Un guide pour s’initier à des postures de yoga spécifiques à l’escalade et pour exécuter des séquences d’enchaînements complémentaires à votre pratique de la montagne.'),(24,'Push ! La vie au bout des mains','Tommy Caldwell',1,'https://static.fnac-static.com/multimedia/Images/FR/NR/08/78/8d/9271304/1507-1/tsp20180220080114/Push-La-vie-au-bout-des-mains.jpg',3,'2018-05-02','L’incroyable histoire de Tommy Caldwell qui, avant de devenir l’un des meilleurs grimpeurs du monde, a dû faire un jour ce choix : mourir ou tuer.');
/*!40000 ALTER TABLE `topos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `address` varchar(500) NOT NULL,
  `zip` int NOT NULL,
  `mail` varchar(100) NOT NULL,
  `phone` int NOT NULL,
  `role` enum('USER','ADMINISTRATOR','MEMBER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'frip','dffe40488a83ff1d70baf838f4822742','Dubois','Fripouille',1,'592 rue Saint Pierre',13010,'fripouille@gmail.com',603030303,'USER'),(2,'geo','0e618f02aa69c1ecfb272608728ecb47','Dubois','Geoffrey',1,'592, RUE SAINT PIERRE',13010,'duboisgeoffrey03@gmail.com',605187022,'ADMINISTRATOR'),(3,'gaga','18a7cfbe79fa83a53e7ffbd9531195d3','Dubois','gaëtan',1,'52 rue st tronc',13011,'gaga@gmail.com',302050819,'MEMBER'),(5,'double','9d7ccbd754eff5503f263860abf033ce','Double','celia',0,'12 rue du mulet',13000,'doublecelia@gmail.com',442323634,'USER'),(6,'eddie','83cafc2f178140b979be1fb346da9a33','Laifa','eddie',1,'236 rue de lioto',13022,'laifaeddie@gmail.com',908070605,'USER'),(8,'mymy','56ae1a9b9dcb880a1f65d908ff838b8f','Fernandez','mylene',0,'23 boulevard st marcel',13005,'fernandezmylene@gmail.com',503010506,'MEMBER'),(36,'mika','f45509655f3cef693cb6ec7c801de7fd','Long','Mickaêl',1,'42 rue de st marcel',13011,'mika@gmail.com',504060302,'USER'),(39,'coco','db09cacc93f69830c35998a7270070af','Genet','Coline',0,'21 bdv des comique',13005,'gen@gmail.com',605121091,'USER'),(40,'matt','96a338374a276c5cf1aae42f405d5bf9','Cartier','Mathieu',1,'23 boulevard de st menet',25012,'mat@gmail.com',601010101,'USER'),(41,'rem','78c72f3eab2294aa32565dc83f1bc716','turki','rémi',1,'21 rue d\'aubagne',13011,'rem@gmail.com',609080709,'USER'),(42,'gérard','f1c152f292585f3244e6d1af3c958f7e','Poidevin','Gérard',1,'41 rue des carvin',62260,'gp@gmail.com',320125465,'USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_climbup'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-14 20:15:05
