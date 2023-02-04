-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 04 fév. 2023 à 18:06
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gl`
--

-- --------------------------------------------------------

--
-- Structure de la table `administateur`
--

CREATE TABLE `administateur` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `administateur`
--

INSERT INTO `administateur` (`login`, `password`) VALUES
('admin', '171645e99f79644abfc787945397c07d77d884e0');

-- --------------------------------------------------------

--
-- Structure de la table `atr`
--

CREATE TABLE `atr` (
  `id_doc` int(11) NOT NULL,
  `year` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `atr`
--

INSERT INTO `atr` (`id_doc`, `year`) VALUES
(1, 3),
(3, 2);

-- --------------------------------------------------------

--
-- Structure de la table `cvs`
--

CREATE TABLE `cvs` (
  `id_doc` int(11) NOT NULL,
  `company_name` varchar(60) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `address_company` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cvs`
--

INSERT INTO `cvs` (`id_doc`, `company_name`, `start_date`, `end_date`, `address_company`) VALUES
(4, 'capgemini', '2023-02-03', '2023-03-04', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `documents`
--

CREATE TABLE `documents` (
  `id_doc` int(10) NOT NULL,
  `type` enum('attestation de réussite','attestation de scolarité','convention de stage','relevé de notes') NOT NULL,
  `n_apogee` varchar(10) NOT NULL,
  `statut` enum('n_traite','accepte','refuse') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `documents`
--

INSERT INTO `documents` (`id_doc`, `type`, `n_apogee`, `statut`) VALUES
(1, 'attestation de réussite', '19040599', 'accepte'),
(2, 'attestation de scolarité', '19040633', 'accepte'),
(3, 'attestation de réussite', '19040633', 'accepte'),
(4, 'convention de stage', '19040599', 'accepte'),
(5, 'relevé de notes', '19040599', 'refuse');

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE `etudiants` (
  `n_apogee` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cin` varchar(10) NOT NULL,
  `cne` varchar(20) NOT NULL,
  `date_naissance` varchar(50) NOT NULL,
  `start_year` enum('0','1') NOT NULL,
  `filiere` enum('Génie Informatique','Supply Chain Management','Génie des Systèmes Télecomunication et Réseau','Génie Mécatronique','Génie Civil') NOT NULL,
  `actual_semester` int(10) NOT NULL,
  `adm_state` enum('0','1','2') NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiants`
--

INSERT INTO `etudiants` (`n_apogee`, `name`, `email`, `cin`, `cne`, `date_naissance`, `start_year`, `filiere`, `actual_semester`, `adm_state`) VALUES
('19040599', 'SAMADI Nada', 'nada.samadi@etu.uae.ac.ma', 'la194514', 'R102781', '19 Septembre 2001', '0', 'Génie Informatique', 7, '2'),
('19054874', 'manal sabiri', 'manal.sabiri@etu.uae.ac.ma', 'ua194514', '12', '19 Septembre 2002', '1', 'Génie Informatique', 7, '0'),
('123', 'test', 'test@gmail.com', '123', 'cneTest', '10 Mars 1999', '0', 'Génie Mécatronique', 4, '2'),
('19040630', 'EL BROUZI Mehdi', 'mehdi.elbrouzi@etu.uae.ac.ma', 'X420857', 'N135310535', '31 Juillet 2002', '0', '', 1, '0'),
('19040631', 'AIT ALI Zakaria', 'zakaria.aitali@etu.uae.ac.ma', 'DN42670', 'M134493549', '16 Avril 2001', '1', '', 2, '1'),
('19040632', 'YAAKOUBI Oumaima', 'oumaima.yaakoubi@etu.uae.ac.ma', 'A310098', 'A19040630', '12 Décembre 2000', '0', '', 3, '2'),
('19040633', 'YASSINE Jaafar', 'jaafar.yassine@etu.uae.ac.ma', 'B293144', 'B192310641', '01 Février 2003', '1', '', 4, '0'),
('19040634', 'NADARI Reda', 'reda.nadari@etu.uae.ac.ma', 'GB28190', 'T130980312', '20 Juin 2003', '0', 'Supply Chain Management', 5, '1'),
('19040635', 'BEKKOUR Ayoub', 'ayoub.bekkour@etu.uae.ac.ma', 'GB30130', 'L192406300', '23 Novembre 2003', '1', 'Supply Chain Management', 6, '2'),
('19040636', 'MARSI Saif', 'saif.marsi@etu.uae.ac.ma', 'Q210932', 'N710298036', '30 Juillet 2001', '0', 'Génie Civil', 7, '0'),
('19040637', 'Zerktouni Mohamed', 'mohamed.zerktouni@etu.uae.ac.ma', 'H210390', 'AB169320654', '02 Fevrier 2000', '1', 'Génie Mécatronique', 8, '1'),
('19040638', 'CHIHA Aya', 'aya.chiha@etu.uae.ac.ma', 'DN39028', 'N138910327', '09 Novembre 1999', '0', 'Génie des Systèmes Télecomunication et Réseau', 9, '2'),
('19040640', 'FATIHI Mohamed', 'mohamed.fatihi@et.uae.ac.ma', 'H120387', 'L210398014', '01 Janvier 2001', '1', 'Génie des Systèmes Télecomunication et Réseau', 10, '2');

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

CREATE TABLE `notes` (
  `n_apogee` int(10) NOT NULL,
  `nom_module` varchar(20) NOT NULL,
  `semestre` int(10) NOT NULL,
  `note` double(4,2) NOT NULL,
  `statut` enum('Validé','Non Validé') NOT NULL,
  `points_jury` varchar(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `notes`
--

INSERT INTO `notes` (`n_apogee`, `nom_module`, `semestre`, `note`, `statut`, `points_jury`) VALUES
(123, 'analyse1', 1, 15.00, '', ''),
(123, 'algebre1', 1, 11.00, '', ''),
(123, 'physique1', 1, 13.00, '', ''),
(123, 'mecanique1', 1, 12.00, '', ''),
(123, 'tec1', 1, 10.00, '', ''),
(123, 'info1', 1, 14.00, '', ''),
(123, 'analyse2', 2, 15.00, '', ''),
(123, 'algebre2', 2, 15.75, '', ''),
(123, 'physique2', 2, 13.00, '', ''),
(123, 'mecanique2', 2, 14.60, '', ''),
(123, 'tec2', 2, 11.00, '', ''),
(123, 'info2', 2, 13.00, '', ''),
(123, 'analyse3', 3, 11.25, '', ''),
(123, 'algebre3', 3, 11.50, '', ''),
(123, 'physique3', 3, 15.00, '', ''),
(123, 'mecanique3', 3, 14.00, '', ''),
(123, 'tec3', 3, 10.00, '', ''),
(123, 'info3', 3, 14.00, '', ''),
(123, 'analyse4', 4, 15.00, '', ''),
(123, 'algebre4', 4, 11.00, '', ''),
(123, 'physique4', 4, 11.25, '', ''),
(123, 'mecanique4', 4, 12.00, '', ''),
(123, 'tec4', 4, 10.00, '', ''),
(123, 'managment1', 4, 16.00, '', ''),
(123, 'theorie des graphes', 5, 15.00, '', ''),
(123, 'base de données', 5, 17.00, '', ''),
(123, 'probabilité et stat', 5, 13.00, '', ''),
(123, 'réseaux informatique', 5, 12.00, '', ''),
(123, 'tec5', 5, 10.00, '', ''),
(123, 'managment5', 5, 14.00, '', ''),
(19054874, 'Physique 1', 1, 13.00, 'Validé', '3'),
(19054874, 'Analyse 1', 1, 12.00, 'Validé', '2'),
(19054874, 'Algebre 1', 1, 10.00, 'Non Validé', ''),
(19054874, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19054874, 'Informatique 1', 1, 6.00, 'Non Validé', ''),
(19054874, 'TEC 1', 1, 6.00, 'Non Validé', ''),
(19054874, 'Physique 2', 2, 14.00, 'Validé', '4'),
(19054874, 'Analyse 2', 2, 10.00, 'Validé', ''),
(19054874, 'Algebre 2', 2, 11.50, 'Validé', ''),
(19054874, 'Mecanique 2', 2, 15.30, 'Validé', '3'),
(19054874, 'Informatique 2', 2, 16.00, 'Validé', '5'),
(19054874, 'TEC 2', 2, 12.10, 'Validé', '1'),
(19054874, 'Physique 3', 3, 11.00, 'Validé', ''),
(19054874, 'Analyse 3', 3, 11.00, 'Validé', ''),
(19054874, 'Algebre 3', 3, 11.50, 'Validé', ''),
(19054874, 'Mecanique 3', 3, 12.30, 'Validé', ''),
(19054874, 'Management 1', 3, 14.00, 'Validé', ''),
(19054874, 'TEC 3', 3, 17.10, 'Validé', '2'),
(19054874, 'Physique 4', 4, 12.00, 'Validé', '2'),
(19054874, 'Analyse 4', 4, 13.00, 'Validé', '3'),
(19054874, 'Algebre 4', 4, 14.50, 'Validé', ''),
(19054874, 'Matlab', 4, 11.30, 'Validé', ''),
(19054874, 'Management 2', 4, 16.00, 'Validé', ''),
(19054874, 'TEC 4', 4, 14.50, 'Validé', ''),
(19054874, 'Probabilite et stati', 5, 15.00, 'Validé', ''),
(19054874, 'Theorie des graphes', 5, 16.00, 'Validé', ''),
(19054874, 'Management 3', 5, 13.50, 'Validé', ''),
(19054874, 'Base de donnees', 5, 17.00, 'Validé', ''),
(19054874, 'TEC 5', 5, 14.10, 'Validé', ''),
(19054874, 'Physique 6', 6, 13.00, 'Validé', ''),
(19054874, 'Analyse 6', 6, 12.00, 'Validé', '2'),
(19054874, 'Algebre 6', 6, 9.00, 'Non Validé', ''),
(19054874, 'Mecanique 6', 6, 8.00, 'Non Validé', ''),
(19054874, 'Informatique 6', 6, 12.00, 'Validé', ''),
(19054874, 'TEC 6', 6, 16.00, 'Validé', ''),
(19054874, 'Physique 7', 7, 13.00, 'Validé', '2'),
(19054874, 'Analyse 7', 7, 12.00, 'Validé', '1'),
(19054874, 'Algebre 7', 7, 12.00, 'Validé', '1'),
(19054874, 'Mecanique 7', 7, 19.00, 'Validé', ''),
(19054874, 'Informatique 7', 7, 14.00, 'Validé', ''),
(19054874, 'TEC 7', 7, 16.00, 'Validé', '2'),
(19040599, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040599, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040599, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040599, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040599, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040599, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040599, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040599, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040599, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040599, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040599, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040599, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040599, 'Physique 3', 3, 11.00, 'Validé', ''),
(19040599, 'Analyse 3', 3, 14.00, 'Validé', ''),
(19040599, 'Algebre 3', 3, 18.00, 'Validé', '3'),
(19040599, 'Mecanique 3', 3, 19.00, 'Validé', '5'),
(19040599, 'Informatique 3', 3, 12.50, 'Validé', ''),
(19040599, 'TEC 3', 3, 13.28, 'Validé', ''),
(19040599, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040599, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040599, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040599, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040599, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040599, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040599, 'Physique 5', 5, 14.00, 'Validé', '1'),
(19040599, 'Analyse 5', 5, 13.00, 'Validé', '2'),
(19040599, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040599, 'Mecanique 5', 5, 4.00, 'Non Validé', ''),
(19040599, 'Informatique 5', 5, 13.50, 'Validé', ''),
(19040599, 'TEC 5', 5, 16.00, 'Validé', ''),
(19040599, 'Physique 6', 6, 11.00, 'Validé', ''),
(19040599, 'Analyse 6', 6, 14.00, 'Validé', ''),
(19040599, 'Algebre 6', 6, 18.00, 'Validé', '3'),
(19040599, 'Mecanique 6', 6, 19.00, 'Validé', '5'),
(19040599, 'Informatique 6', 6, 12.50, 'Validé', ''),
(19040599, 'TEC 6', 6, 13.28, 'Validé', ''),
(19040599, 'Physique 7', 7, 14.40, 'Validé', '3'),
(19040599, 'Analyse 7', 7, 12.00, 'Validé', '2'),
(19040599, 'Algebre 7', 7, 8.00, 'Non Validé', ''),
(19040599, 'Mecanique 7', 7, 9.00, 'Non Validé', ''),
(19040599, 'Informatique 7', 7, 8.00, 'Non Validé', ''),
(19040599, 'TEC 7', 7, 14.00, 'Validé', ''),
(19040634, 'Mecanique 5', 5, 14.00, 'Validé', ''),
(19040634, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040634, 'Analyse 5', 5, 13.75, 'Validé', '2'),
(19040634, 'Physique 5', 5, 14.50, 'Validé', '1'),
(19040634, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040634, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040634, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040634, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040634, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040634, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040634, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040634, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040634, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040634, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040634, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040634, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040634, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040634, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040634, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040634, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040634, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040634, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040634, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040634, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040634, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040634, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040634, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040634, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040633, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040633, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040633, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040633, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040633, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040633, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040633, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040633, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040633, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040633, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040633, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040633, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040633, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040633, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040633, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040633, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040633, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040633, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040633, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040633, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040633, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040633, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040633, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040633, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040632, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040632, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040632, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040632, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040632, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040632, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040632, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040632, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040632, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040632, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040632, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040632, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040632, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040632, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040632, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040632, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040632, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040632, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040631, 'TEC 2', 2, 14.88, 'Validé', ''),
(19040631, 'Informatique 2', 2, 15.50, 'Validé', ''),
(19040631, 'Mecanique 2', 2, 16.60, 'Validé', '5'),
(19040631, 'Algebre 2', 2, 18.50, 'Validé', '3'),
(19040631, 'Analyse 2', 2, 14.50, 'Validé', ''),
(19040631, 'Physique 2', 2, 12.33, 'Validé', ''),
(19040631, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040631, 'Informatique 1', 1, 13.50, 'Validé', ''),
(19040631, 'Mecanique 1', 1, 4.00, 'Non Validé', ''),
(19040631, 'Algebre 1', 1, 15.30, 'Validé', '1'),
(19040631, 'Analyse 1', 1, 13.00, 'Validé', '2'),
(19040631, 'Physique 1', 1, 14.00, 'Validé', '1'),
(19040630, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040630, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040630, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040630, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040630, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040630, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040634, 'Informatique 5', 5, 17.50, 'Validé', ''),
(19040634, 'TEC 5', 5, 12.00, 'Validé', ''),
(19040635, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040635, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040635, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040635, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040635, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040635, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040635, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040635, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040635, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040635, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040635, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040635, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040635, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040635, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040635, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040635, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040635, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040635, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040635, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040635, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040635, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040635, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040635, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040635, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040635, 'Physique 5', 5, 14.50, 'Validé', '1'),
(19040635, 'Analyse 5', 5, 13.75, 'Validé', '2'),
(19040635, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040635, 'Mecanique 5', 5, 14.00, 'Validé', ''),
(19040635, 'Informatique 5', 5, 17.50, 'Validé', ''),
(19040635, 'TEC 5', 5, 12.00, 'Validé', ''),
(19040635, 'Physique 6', 6, 8.11, 'Non Validé', ''),
(19040635, 'Analyse 6', 6, 18.80, 'Validé', ''),
(19040635, 'Algebre 6', 6, 16.00, 'Validé', '3'),
(19040635, 'Mecanique 6', 6, 17.09, 'Validé', '5'),
(19040635, 'Informatique 6', 6, 13.50, 'Validé', ''),
(19040635, 'TEC 6', 6, 13.28, 'Validé', ''),
(19040636, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040636, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040636, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040636, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040636, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040636, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040636, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040636, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040636, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040636, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040636, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040636, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040636, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040636, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040636, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040636, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040636, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040636, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040636, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040636, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040636, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040636, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040636, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040636, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040636, 'Physique 5', 5, 14.50, 'Validé', '1'),
(19040636, 'Analyse 5', 5, 13.75, 'Validé', '2'),
(19040636, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040636, 'Mecanique 5', 5, 14.00, 'Validé', ''),
(19040636, 'Informatique 5', 5, 17.50, 'Validé', ''),
(19040636, 'TEC 5', 5, 12.00, 'Validé', ''),
(19040636, 'Physique 6', 6, 8.11, 'Non Validé', ''),
(19040636, 'Analyse 6', 6, 18.80, 'Validé', ''),
(19040636, 'Algebre 6', 6, 16.00, 'Validé', '3'),
(19040636, 'Mecanique 6', 6, 17.09, 'Validé', '5'),
(19040636, 'Informatique 6', 6, 13.50, 'Validé', ''),
(19040636, 'TEC 6', 6, 13.28, 'Validé', ''),
(19040636, 'Physique 7', 7, 1.00, '', ''),
(19040636, 'Analyse 7', 7, 12.75, 'Validé', ''),
(19040636, 'Algebre 7', 7, 15.00, 'Validé', '3'),
(19040636, 'Mecanique 7', 7, 13.00, 'Validé', '5'),
(19040636, 'Informatique 7', 7, 15.50, 'Validé', ''),
(19040636, 'TEC 7', 7, 11.33, 'Non Validé', ''),
(19040637, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040637, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040637, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040637, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040637, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040637, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040637, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040637, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040637, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040637, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040637, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040637, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040637, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040637, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040637, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040637, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040637, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040637, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040637, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040637, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040637, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040637, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040637, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040637, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040637, 'Physique 5', 5, 14.50, 'Validé', '1'),
(19040637, 'Analyse 5', 5, 13.75, 'Validé', '2'),
(19040637, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040637, 'Mecanique 5', 5, 14.00, 'Validé', ''),
(19040637, 'Informatique 5', 5, 17.50, 'Validé', ''),
(19040637, 'TEC 5', 5, 12.00, 'Validé', ''),
(19040637, 'Physique 6', 6, 8.11, 'Non Validé', ''),
(19040637, 'Analyse 6', 6, 18.80, 'Validé', ''),
(19040637, 'Algebre 6', 6, 16.00, 'Validé', '3'),
(19040637, 'Mecanique 6', 6, 17.09, 'Validé', '5'),
(19040637, 'Informatique 6', 6, 13.50, 'Validé', ''),
(19040637, 'TEC 6', 6, 13.28, 'Validé', ''),
(19040637, 'Physique 7', 7, 1.00, '', ''),
(19040637, 'Analyse 7', 7, 12.75, 'Validé', ''),
(19040637, 'Algebre 7', 7, 15.00, 'Validé', '3'),
(19040637, 'Mecanique 7', 7, 13.00, 'Validé', '5'),
(19040637, 'Informatique 7', 7, 15.50, 'Validé', ''),
(19040637, 'TEC 7', 7, 11.33, 'Non Validé', ''),
(19040637, 'Physique 8', 8, 14.50, 'Validé', '1'),
(19040637, 'Analyse 8', 8, 13.75, 'Validé', '2'),
(19040637, 'Algebre 8', 8, 15.30, 'Validé', '1'),
(19040637, 'Mecanique 8', 8, 14.00, 'Validé', ''),
(19040637, 'Informatique 8', 8, 17.50, 'Validé', ''),
(19040637, 'TEC 8', 8, 12.00, 'Validé', ''),
(19040638, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040638, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040638, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040638, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040638, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040638, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040638, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040638, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040638, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040638, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040638, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040638, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040638, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040638, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040638, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040638, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040638, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040638, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040638, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040638, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040638, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040638, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040638, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040638, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040638, 'Physique 5', 5, 14.50, 'Validé', '1'),
(19040638, 'Analyse 5', 5, 13.75, 'Validé', '2'),
(19040638, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040638, 'Mecanique 5', 5, 14.00, 'Validé', ''),
(19040638, 'Informatique 5', 5, 17.50, 'Validé', ''),
(19040638, 'TEC 5', 5, 12.00, 'Validé', ''),
(19040638, 'Physique 6', 6, 8.11, 'Non Validé', ''),
(19040638, 'Analyse 6', 6, 18.80, 'Validé', ''),
(19040638, 'Algebre 6', 6, 16.00, 'Validé', '3'),
(19040638, 'Mecanique 6', 6, 17.09, 'Validé', '5'),
(19040638, 'Informatique 6', 6, 13.50, 'Validé', ''),
(19040638, 'TEC 6', 6, 13.28, 'Validé', ''),
(19040638, 'Physique 7', 7, 1.00, '', ''),
(19040638, 'Analyse 7', 7, 12.75, 'Validé', ''),
(19040638, 'Algebre 7', 7, 15.00, 'Validé', '3'),
(19040638, 'Mecanique 7', 7, 13.00, 'Validé', '5'),
(19040638, 'Informatique 7', 7, 15.50, 'Validé', ''),
(19040638, 'TEC 7', 7, 11.33, 'Non Validé', ''),
(19040638, 'Physique 8', 8, 14.50, 'Validé', '1'),
(19040638, 'Analyse 8', 8, 13.75, 'Validé', '2'),
(19040638, 'Algebre 8', 8, 15.30, 'Validé', '1'),
(19040638, 'Mecanique 8', 8, 14.00, 'Validé', ''),
(19040637, 'Informatique 8', 8, 17.50, 'Validé', ''),
(19040638, 'TEC 8', 8, 12.00, 'Validé', ''),
(19040638, 'Physique 9', 9, 8.11, 'Non Validé', ''),
(19040638, 'Analyse 6', 9, 18.80, 'Validé', ''),
(19040638, 'Algebre 9', 9, 16.00, 'Validé', '3'),
(19040638, 'Mecanique 9', 9, 17.09, 'Validé', '5'),
(19040638, 'Informatique 9', 9, 13.50, 'Validé', ''),
(19040638, 'TEC 9', 9, 13.28, 'Validé', ''),
(19040640, 'Physique 1', 1, 11.00, 'Validé', '3'),
(19040640, 'Analyse 1', 1, 10.00, 'Validé', '2'),
(19040640, 'Algebre 1', 1, 8.00, 'Non Validé', ''),
(19040640, 'Mecanique 1', 1, 9.00, 'Non Validé', ''),
(19040640, 'Informatique 1', 1, 12.00, 'Validé', ''),
(19040640, 'TEC 1', 1, 16.00, 'Validé', ''),
(19040640, 'Physique 2', 2, 14.00, 'Validé', '1'),
(19040640, 'Analyse 2', 2, 13.00, 'Validé', '2'),
(19040640, 'Algebre 2', 2, 15.30, 'Validé', '1'),
(19040640, 'Mecanique 2', 2, 4.00, 'Non Validé', ''),
(19040640, 'Informatique 2', 2, 13.50, 'Validé', ''),
(19040640, 'TEC 2', 2, 16.00, 'Validé', ''),
(19040640, 'Physique 3', 3, 12.33, 'Validé', ''),
(19040640, 'Analyse 3', 3, 14.50, 'Validé', ''),
(19040640, 'Algebre 3', 3, 18.50, 'Validé', '3'),
(19040640, 'Mecanique 3', 3, 16.60, 'Validé', '5'),
(19040640, 'Informatique 3', 3, 15.50, 'Validé', ''),
(19040640, 'TEC 3', 3, 14.88, 'Validé', ''),
(19040640, 'Physique 4', 4, 11.00, 'Validé', '3'),
(19040640, 'Analyse 4', 4, 10.00, 'Validé', '2'),
(19040640, 'Algebre 4', 4, 8.00, 'Non Validé', ''),
(19040640, 'Mecanique 4', 4, 9.00, 'Non Validé', ''),
(19040640, 'Informatique 4', 4, 12.00, 'Validé', ''),
(19040640, 'TEC 4', 4, 16.00, 'Validé', ''),
(19040640, 'Physique 5', 5, 14.50, 'Validé', '1'),
(19040640, 'Analyse 5', 5, 13.75, 'Validé', '2'),
(19040640, 'Algebre 5', 5, 15.30, 'Validé', '1'),
(19040640, 'Mecanique 5', 5, 14.00, 'Validé', ''),
(19040640, 'Informatique 5', 5, 17.50, 'Validé', ''),
(19040640, 'TEC 5', 5, 12.00, 'Validé', ''),
(19040640, 'Physique 6', 6, 8.11, 'Non Validé', ''),
(19040640, 'Analyse 6', 6, 18.80, 'Validé', ''),
(19040640, 'Algebre 6', 6, 16.00, 'Validé', '3'),
(19040640, 'Mecanique 6', 6, 17.09, 'Validé', '5'),
(19040640, 'Informatique 6', 6, 13.50, 'Validé', ''),
(19040640, 'TEC 6', 6, 13.28, 'Validé', ''),
(19040640, 'Physique 7', 7, 1.00, '', ''),
(19040640, 'Analyse 7', 7, 12.75, 'Validé', ''),
(19040640, 'Algebre 7', 7, 15.00, 'Validé', '3'),
(19040640, 'Mecanique 7', 7, 13.00, 'Validé', '5'),
(19040640, 'Informatique 7', 7, 15.50, 'Validé', ''),
(19040640, 'TEC 7', 7, 11.33, 'Non Validé', ''),
(19040640, 'Physique 8', 8, 14.50, 'Validé', '1'),
(19040640, 'Analyse 8', 8, 13.75, 'Validé', '2'),
(19040640, 'Algebre 8', 8, 15.30, 'Validé', '1'),
(19040640, 'Mecanique 8', 8, 14.00, 'Validé', ''),
(19040640, 'Informatique 8', 8, 17.50, 'Validé', ''),
(19040638, 'Informatique 8', 8, 17.50, 'Validé', ''),
(19040640, 'TEC 8', 8, 12.00, 'Validé', ''),
(19040640, 'Physique 9', 9, 8.11, 'Non Validé', ''),
(19040640, 'Analyse 6', 9, 18.80, 'Validé', ''),
(19040640, 'Algebre 9', 9, 16.00, 'Validé', '3'),
(19040640, 'Mecanique 9', 9, 17.09, 'Validé', '5'),
(19040640, 'Informatique 9', 9, 13.50, 'Validé', ''),
(19040640, 'TEC 9', 9, 13.28, 'Validé', ''),
(19040640, 'Physique 10', 10, 1.00, '', ''),
(19040640, 'Analyse 10', 10, 12.75, 'Validé', ''),
(19040640, 'Algebre 10', 10, 15.00, 'Validé', '3'),
(19040640, 'Mecanique 10', 10, 13.00, 'Validé', '5'),
(19040640, 'Informatique 10', 10, 15.50, 'Validé', ''),
(19040640, 'TEC 10', 10, 11.33, 'Non Validé', '');

-- --------------------------------------------------------

--
-- Structure de la table `releve`
--

CREATE TABLE `releve` (
  `id_doc` int(11) NOT NULL,
  `year` int(2) DEFAULT -1,
  `semester` int(2) DEFAULT -1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `releve`
--

INSERT INTO `releve` (`id_doc`, `year`, `semester`) VALUES
(5, 2, -1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administateur`
--
ALTER TABLE `administateur`
  ADD PRIMARY KEY (`login`);

--
-- Index pour la table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`id_doc`);

--
-- Index pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`n_apogee`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `documents`
--
ALTER TABLE `documents`
  MODIFY `id_doc` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
