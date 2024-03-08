import { Pickup } from "@/app/types/Types";
import React from "react";
type Props = {
  pickup: Pickup;
};
export const PickupInfo = ({ pickup }: Props) => {
  const isActive = pickup.active ? "Yes" : "No";
  return (
    <div className="flex flex-col text-xl items-center md:flex-row md:items-start md:justify-center">
      <ul className="w-3/4 shadow-lg m-2 md:w-1/3 p-5">
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 md:mt-1">Brand:</p>
          <p className="mb-1">{pickup.brandName}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Type:</p>
          <p className="mb-1 mt-1">{pickup.type}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Wiring:</p>
          <p className="mb-1 mt-1">{pickup.wiring}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Position:</p>
          <p className="mb-1 mt-1">{pickup.position}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Active:</p>
          <p className="mb-1 mt-1">{isActive}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Output:</p>
          <p className="mb-1 mt-1">{pickup.output}</p>
        </li>
        <li className="flex flex-row justify-between border-slate-600 border-b-2">
          <p className="mb-1 mt-1">Color:</p>
          <p className="mb-1 mt-1">{pickup.color}</p>
        </li>
      </ul>
    </div>
  );
};
