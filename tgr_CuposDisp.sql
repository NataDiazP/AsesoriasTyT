DELIMITER // 
CREATE TRIGGER cuposDisponibles
AFTER INSERT ON estudiantes_asesoria FOR EACH ROW 
BEGIN 
DECLARE cuposAse INT;
SELECT ase.CuposDisp_Asesoria INTO cuposAse 
FROM asesorias ase
WHERE ase.Id_Asesoria = NEW.Id_Asesoria;

IF cuposAse > 0 THEN
	UPDATE asesorias SET CuposDisp_Asesoria = cuposAse - 1 WHERE Id_Asesoria = NEW.Id_Asesoria;
END IF;

END// 
