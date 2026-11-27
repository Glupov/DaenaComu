ALTER TABLE cursos
    ADD COLUMN IF NOT EXISTS imagem_url TEXT,
    DROP COLUMN IF EXISTS mostruario_gratis;

