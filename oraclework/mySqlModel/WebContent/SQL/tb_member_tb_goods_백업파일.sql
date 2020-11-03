-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.62 - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 dev37db.tb_goods 구조 내보내기
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE IF NOT EXISTS `tb_goods` (
  `g_code` varchar(20) NOT NULL,
  `m_id` varchar(20) NOT NULL,
  `g_name` varchar(20) NOT NULL,
  `g_cate` varchar(20) NOT NULL,
  `g_price` varchar(20) NOT NULL,
  `g_color` varchar(20) NOT NULL,
  `g_size` varchar(20) NOT NULL,
  `g_date` varchar(20) NOT NULL,
  `g_desc` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`g_code`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 dev37db.tb_goods:~3 rows (대략적) 내보내기
/*!40000 ALTER TABLE `tb_goods` DISABLE KEYS */;
INSERT INTO `tb_goods` (`g_code`, `m_id`, `g_name`, `g_cate`, `g_price`, `g_color`, `g_size`, `g_date`, `g_desc`) VALUES
	('goods_1', 'id001', '1', '1', '1', '1', '1', '2020-09-23 16:59:53', '1'),
	('goods_2', 'id002', '2', '2', '2', '2', '2', '2020-09-23 16:59:53', '2');
/*!40000 ALTER TABLE `tb_goods` ENABLE KEYS */;

-- 테이블 dev37db.tb_member 구조 내보내기
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE IF NOT EXISTS `tb_member` (
  `m_id` varchar(10) NOT NULL,
  `m_pw` varchar(10) NOT NULL,
  `m_level` varchar(10) NOT NULL,
  `m_name` varchar(20) NOT NULL,
  `m_email` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;

-- 테이블 데이터 dev37db.tb_member:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `tb_member` DISABLE KEYS */;
INSERT INTO `tb_member` (`m_id`, `m_pw`, `m_level`, `m_name`, `m_email`) VALUES
	('9', '9', '9', '9', '9'),
	('id001', 'pw001', '관리자', '홍01', 'test01'),
	('id002', 'pw002', '판매자', '홍02', 'test02'),
	('id003', 'pw003', '판매자', '홍03', 'test03'),
	('id004', 'pw004', '구매자', '홍04', 'test04'),
	('id005', 'pw005', '구매자', '홍05', 'test05');
/*!40000 ALTER TABLE `tb_member` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
