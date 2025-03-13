import { type ReactNode } from "react";
import { ArtistContext } from "@/context/ArtistContext";
import { useEntity } from "@/hooks";
import type { ArtistType } from "@/types";
import artistMock from "@/mocks/artistMock.json";

export const ArtistProvider = ({ children }: { children: ReactNode }) => {
  const { state, addEntity, deleteEntity, updateEntity, getEntityById } =
    useEntity<ArtistType>(artistMock.artists);

  return (
    <ArtistContext.Provider
      value={{
        artistsList: state,
        addArtist: addEntity,
        deleteArtist: deleteEntity,
        updateArtistsList: updateEntity,
        getArtistById: getEntityById,
      }}
    >
      {children}
    </ArtistContext.Provider>
  );
};
