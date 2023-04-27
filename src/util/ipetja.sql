-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28-Abr-2023 às 00:21
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ipetja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `adocao`
--

CREATE TABLE `adocao` (
  `idadocao` int(11) NOT NULL,
  `idanimal` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idfuncionario` int(11) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE `animal` (
  `idanimal` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `idade` varchar(15) NOT NULL,
  `sexo` varchar(25) NOT NULL,
  `raca` varchar(25) NOT NULL,
  `status` char(1) NOT NULL,
  `descricao` varchar(500) NOT NULL,
  `idfuncionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`idanimal`, `nome`, `idade`, `sexo`, `raca`, `status`, `descricao`, `idfuncionario`) VALUES
(4, 'Steel', '1 ano', 'Macho', 'Calopisita', 'P', 'adsklfjhaskjldfhgasdkfljhasdfkljhsdfgç', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfuncionario` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cargo` varchar(25) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `status` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfuncionario`, `nome`, `cargo`, `cpf`, `endereco`, `usuario`, `senha`, `status`) VALUES
(3, 'Gustavo', 'Veterinário', '12345678912', 'adssfafasf', 'gus', '123', 'A'),
(4, 'Tiago', 'Administrador', '12365478912', 'asdfasfasgfagfagf', 'tiago', '123', 'A');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `adocao`
--
ALTER TABLE `adocao`
  ADD PRIMARY KEY (`idadocao`),
  ADD KEY `idanimal` (`idanimal`),
  ADD KEY `idcliente` (`idcliente`),
  ADD KEY `idfuncionario` (`idfuncionario`);

--
-- Índices para tabela `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`idanimal`),
  ADD KEY `idfuncionario` (`idfuncionario`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `adocao`
--
ALTER TABLE `adocao`
  MODIFY `idadocao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `animal`
--
ALTER TABLE `animal`
  MODIFY `idanimal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `adocao`
--
ALTER TABLE `adocao`
  ADD CONSTRAINT `adocao_ibfk_1` FOREIGN KEY (`idanimal`) REFERENCES `animal` (`idanimal`),
  ADD CONSTRAINT `adocao_ibfk_2` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  ADD CONSTRAINT `adocao_ibfk_3` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`idfuncionario`);

--
-- Limitadores para a tabela `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`idfuncionario`) REFERENCES `funcionario` (`idfuncionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
