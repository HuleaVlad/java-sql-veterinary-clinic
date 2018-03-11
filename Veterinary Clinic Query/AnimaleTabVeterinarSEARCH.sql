-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Vlad Hulea
-- Create date: 16/01/2018
-- Description:	
-- =============================================
ALTER PROCEDURE AnimaleTabVeterinarSEARCH 
	-- Add the parameters for the stored procedure here
	
	@nume_v nchar
	,@prenume_v nchar
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT A.id_animal
			,A.greutate
			,A.sex
			,A.data_nasterii
			,A.id_hrana
			,A.id_proprietar
	FROM Animale AS A
	WHERE A.id_animal IN (SELECT L.id_animal
						  FROM [Link Animale_Veterinari] AS L
						  WHERE L.id_veterinar IN (SELECT V.id_veterinar
												   FROM Veterinari AS V
												   WHERE (((V.nume_v LIKE '%' +@nume_v + '%') OR (@nume_v IS NULL))
												   AND ((V.prenume_v LIKE '%' + @prenume_v + '%') OR (@prenume_v IS NULL))
													)
													)
													)
END
GO
