/**
 * Author:  vikour
 * Created: 30-oct-2018
 */

CREATE TABLE modulo (
    nombre VARCHAR(50) PRIMARY KEY,
    alpha DOUBLE NOT NULL,
    beta DOUBLE NOT NULL,
    gamma DOUBLE NOT NULL,
    kappa DOUBLE NOT NULL
);

CREATE TABLE campanya (
    nombre VARCHAR(50),
    fecha DATE NOT NULL,
    modulo VARCHAR(50) NOT NULL,
    CONSTRAINT campanya_pk PRIMARY KEY (modulo, nombre),
    CONSTRAINT modulo_fk FOREIGN KEY (modulo) REFERENCES modulo(nombre) ON DELETE CASCADE
);

INSERT INTO modulo VALUES
('modulo1', 0.5, 3, 5.3, 6),
('modulo2', 0.7, 1, 4.3, 3),
('modulo4', 0.9, 2, 5.9, 2);

INSERT INTO campanya VALUES
('campaña11', '2018-02-02','modulo1'),
('campaña12', '2017-03-04','modulo1'),
('campaña13', '2018-04-06','modulo1'),
('campaña21', '2018-04-12','modulo2'),
('campaña22', '2018-06-14','modulo2'),
('campaña23', '2018-07-22','modulo2'),
('campaña24', '2016-06-29','modulo2'),
('campaña41', '2018-07-28','modulo4'),
('campaña42', '2014-12-14','modulo4'),
('campaña43', '2018-11-03','modulo4');
