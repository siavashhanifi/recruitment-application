import { Availability } from './availability.entety';
import { CompetenceProfile } from './competence-profile.entety';

/**
 * Model of a jobb application
 */
export class Application {
  applicantName: string;
  applicantSsn: number;
  availability: Availability[];
  competenceProfile: CompetenceProfile;
}
