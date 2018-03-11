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
ALTER PROCEDURE AnimaleTabProprietarSearch 
	-- Add the parameters for the stored procedure here 
	
	@nume_proprietar nchar 
	,@prenume_proprietar nchar

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
	WHERE A.id_proprietar IN (SELECT P.id_proprietar
										FROM Proprietar AS P
										WHERE (((P.nume_proprietar LIKE '%' +@nume_proprietar + '%') OR (@nume_proprietar IS NULL))
												AND ((P.prenume_proprietar LIKE '%' + @prenume_proprietar + '%') OR (@prenume_proprietar IS NULL))
												)
												)

END
GO
