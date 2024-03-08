import { Picks } from "@/app/types/Types";
import React from "react";
type Props = {
  picks: Picks;
};
export const PicksInfo = ({ picks }: Props) => {
  return (
    <div>
      <div className="flex flex-col text-xl items-center md:flex-row md:items-start md:justify-center">
        <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
          <li className="flex flex-row justify-between border-slate-600 border-b-2">
            <p className="mb-1 md:mt-1">Brand:</p>
            <p className="mb-1">{picks.brandName}</p>
          </li>
          <li className="flex flex-row justify-between border-slate-600 border-b-2">
            <p className="mb-1 mt-1">Delivery quantity:</p>
            <p className="mb-1 mt-1">{picks.delivery_quantity}</p>
          </li>
          <li className="flex flex-row justify-between border-slate-600 border-b-2">
            <p className="mb-1 mt-1">Thickness:</p>
            <p className="mb-1 mt-1">{picks.thickness}mm</p>
          </li>
        </ul>
      </div>
    </div>
  );
};
