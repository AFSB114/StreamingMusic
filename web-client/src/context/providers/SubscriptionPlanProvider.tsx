import { ReactNode } from "react";
import { SubscriptionPlanContext } from "@/context/SubscriptionPlanContext";
import { useEntity } from "@/hooks";
import { SubscriptionPlanType } from "@/types";

export const SubscriptionPlanProvider = ({ children }: { children: ReactNode }) => {
  const apiUrl = process.env.NEXT_PUBLIC_API_URL
  const { state, addEntity, deleteEntity, updateEntity, getEntityById, searchEntityBy } =
    useEntity<SubscriptionPlanType>(`${apiUrl}/subscription-plan`, "subscription-plans");

  return (
    <SubscriptionPlanContext.Provider
      value={{
        subscriptionPlansList: state,
        addSubscriptionPlan: addEntity,
        deleteSubscriptionPlan: deleteEntity,
        updateSubscriptionPlan: updateEntity,
        getSubscriptionPlanById: getEntityById,
        searchSubscriptionPlans: searchEntityBy,
      }}
    >
      {children}
    </SubscriptionPlanContext.Provider>
  );
};
