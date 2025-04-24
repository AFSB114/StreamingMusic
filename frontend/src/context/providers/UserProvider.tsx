import { ReactNode } from "react";
import { UserContext } from "@/context/UserContext";
import { useEntity } from "@/hooks";
import { UserType } from "@/types";

export const UserProvider = ({ children }: { children: ReactNode }) => {
  const apiUrl = process.env.NEXT_PUBLIC_API_URL
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<UserType>(`${apiUrl}/user`);

  return (
    <UserContext.Provider
      value={{
        usersList: state,
        addUser: addEntity,
        deleteUser: deleteEntity,
        updateUser: updateEntity,
        getUserById: getEntityById,
        searchUsers: searchEntityBy,
      }}
    >
      {children}
    </UserContext.Provider>
  );
};
